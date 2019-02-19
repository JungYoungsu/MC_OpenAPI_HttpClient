package httpclienttest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

public class Sample4 {
	public static void main(String[] args) throws HttpException, IOException {
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("utf-8");

		String url = "http://70.12.113.130:8000/contactsvc1/contacts";
		PostMethod method = new PostMethod(url); // "생성" 행위를 위해 POST 사용
		method.setRequestHeader("Accept", "application/json");

		String jsonRequest = "{\"name\":\"정영수\", \"tel\":\"010-9383-0009\",\"address\":\"독도\"}";
		StringRequestEntity entity = new StringRequestEntity(jsonRequest, "application/json", "utf-8");
		method.setRequestEntity(entity);

		int status = client.executeMethod(method);
		if (status == 200) {
			String json = method.getResponseBodyAsString();
			System.out.println("## 응답 데이터 : " + json);
		} else {
			System.out.println("## 응답 오류 : 상태코드 => " + status);
		}

	}
}
