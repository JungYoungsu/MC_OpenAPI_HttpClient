package httpclienttest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class Sample1 {

	public static void main(String[] args) throws HttpException, IOException {
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("utf-8");

		// String url = "http://70.12.113.130:8000/contactsvc1/contacts?output=json";
		String url = "http://70.12.113.130:8000/contactsvc1/contacts";
		GetMethod method = new GetMethod(url);
		method.addRequestHeader("Accept", "application/json");	// ?output=json 대신
		
		int status = client.executeMethod(method);
		if (status == 200) {
			String json = method.getResponseBodyAsString();
			System.out.println("## 응답 데이터 : " + json);
		} else {
			System.out.println("## 응답 오류 : 상태코드 => " + status);
		}
	}
}
