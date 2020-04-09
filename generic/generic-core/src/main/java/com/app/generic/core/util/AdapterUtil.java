package com.app.generic.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author M Lukmanul Hakim (m.hakim &copy;Aug 16, 2018)
 * @author Heri Purwanto (heri.purwanto &copy;Sept 17, 2018) <br>
 *         for further info contact: <i>vickyhakimm@gmail.com</i>
 *
 */
@Component
public class AdapterUtil {
	private static final Logger LOG = LogManager.getLogger(AdapterUtil.class);
	@Autowired
	private ObjectMapper objectMapper;
	private HttpPost postRequest;
	private CloseableHttpClient httpClient;
	
	/**
	 * Set HttpPost postRequest & CloseableHttpClient httpClient
	 * must be called before calling sendPost or getSingleHeader
	 * @param url
	 * @return
	 **/ 
	public AdapterUtil setUrl(String url) {
		this.postRequest = new HttpPost(url);
		this.httpClient = HttpClientBuilder.create().build();
		return this;
	}

	/**
	 * Send post API
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Sep 18, 2018) <br>
	 *         for further info contact: <i>vickyhakimm@gmail.com</i>
	 * @param param
	 * @param headers
	 * @return
	 */
	public Object sendPost(Object param, Map<String, String> headers) {
		Object result = null;
		try {
			StringEntity body = new StringEntity(objectMapper.writeValueAsString(param));
			body.setContentType("application/json");
			postRequest.setEntity(body);
			if (headers != null) {
				for (Entry<String, String> header : headers.entrySet()) {
					postRequest.addHeader(header.getKey(), header.getValue());
				}
			}
			HttpResponse response = httpClient.execute(postRequest);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}

			StringBuilder output = new StringBuilder();
			try (BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())))) {
				String stringOutput;
				LOG.info("Output from Server .... \n");
				while ((stringOutput = br.readLine()) != null) {
					output.append(stringOutput);
				}
			} catch (IOException e) {
				LOG.error(e, e);
			}

			result = objectMapper.readValue(output.toString(), Object.class);

		} catch (MalformedURLException e) {
			LOG.error(e, e);
		} catch (IOException e) {
			LOG.error(e, e);
		}
		return result;
	}

	/**
	 * get the single headerName value as String
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Sep 18, 2018) <br>
	 *         for further info contact: <i>vickyhakimm@gmail.com</i>
	 * @param param
	 * @param headers
	 * @param headerName
	 * @return
	 */
	public String getSingleHeader(Object param, Map<String, String> headers, String headerName) {
		String result = null;
		try {
			StringEntity body = new StringEntity(objectMapper.writeValueAsString(param));
			body.setContentType("application/json");
			postRequest.setEntity(body);
			if (headers != null) {
				for (Entry<String, String> header : headers.entrySet()) {
					postRequest.addHeader(header.getKey(), header.getValue());
				}
			}
			HttpResponse response;
			response = httpClient.execute(postRequest);
			result = response.getFirstHeader(headerName).getValue();
		} catch (IOException e) {
			LOG.error(e, e);
		}
		return result;
	}

	public HttpPost getPostRequest() {
		return postRequest;
	}

	public void setPostRequest(HttpPost postRequest) {
		this.postRequest = postRequest;
	}

	public CloseableHttpClient getHttpClient() {
		return httpClient;
	}
}