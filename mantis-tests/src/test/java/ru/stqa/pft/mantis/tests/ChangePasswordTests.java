package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTests extends TestBase {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testChangePassword() throws IOException, MessagingException {
    UserData modifiedUser = app.db().users().iterator().next();
    String newpwd = "newpassword";
    String email = modifiedUser.getEmail();
    app.pwdchange().login(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
    System.out.println(app.getProperty("web.adminLogin"));
    app.pwdchange().initPasswordReset(modifiedUser.getName());
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 50000);
    String confirmationLink = findConfirmationLink(mailMessages, email);
    app.pwdchange().changePassword(confirmationLink, newpwd);
    HttpSession session = app.newSession();
    assertTrue(session.login(modifiedUser.getName(), newpwd));
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}

