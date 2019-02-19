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
		PostMethod method = new PostMethod(url); // "����" ������ ���� POST ���
		method.setRequestHeader("Accept", "application/json");

		String jsonRequest = "{\"name\":\"������\", \"tel\":\"010-9383-0009\",\"address\":\"����\"}";
		StringRequestEntity entity = new StringRequestEntity(jsonRequest, "application/json", "utf-8");
		method.setRequestEntity(entity);

		int status = client.executeMethod(method);
		if (status == 200) {
			String json = method.getResponseBodyAsString();
			System.out.println("## ���� ������ : " + json);
		} else {
			System.out.println("## ���� ���� : �����ڵ� => " + status);
		}

	}
}
