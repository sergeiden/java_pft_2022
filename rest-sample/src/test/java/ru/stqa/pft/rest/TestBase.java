package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.SkipException;

import java.io.IOException;
import java.util.Set;

public class TestBase {

  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

  public  boolean isIssueOpen(int issueId) throws IOException {
    String issueStatus = getIssueData(issueId).iterator().next().getStatus();
    if (issueStatus.equals("Resolved") || issueStatus.equals("Closed"))
      return false;
    else
      return true;
  }

  private Set<Issue> getIssueData(int id) throws IOException {
    String json = getExecutor().execute(Request.Get("https://bugify.stqa.ru/api/issues/" + id + ".json"))
            .returnContent().asString();
    JsonElement parsed = JsonParser.parseString(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {}.getType());
  }

  private Executor getExecutor() {
    return Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490", "");
  }
}