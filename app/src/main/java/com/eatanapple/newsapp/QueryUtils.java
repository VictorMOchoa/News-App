package com.eatanapple.newsapp;

import android.util.Log;

import com.eatanapple.newsapp.dto.Article;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class QueryUtils {

    public static List<Article> fetchArticles(String url) {
        if (url == null) {
            return null;
        }

        URL apiEndpoint = createAPIEndpointURL(url);
        String response = makeAPIRequest(apiEndpoint);

        return transformJsonToArticlesList(response);
    }

    private static List<Article> transformJsonToArticlesList(String response) {
        ObjectMapper mapper = new ObjectMapper();
        List<Article> articles = null;
        try {
            JSONObject object = new JSONObject(response);
            JSONArray results = object.getJSONObject("response").getJSONArray("results");
            String resultsNode = results.toString();
            articles = mapper.readValue(resultsNode, new TypeReference<List<Article>>(){});
        } catch (JSONException | JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }
        return articles;
    }

    private static String makeAPIRequest(URL url) {
        HttpURLConnection urlConnection = null;
        String response = null;
        InputStream inputStream = null;

        if(url == null) {
            return null;
        }

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = urlConnection.getInputStream();
                response = readFromStream(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    private static String readFromStream(InputStream inputStream) {
        InputStreamReader streamReader = null;
        BufferedReader bufferedReader = null;
        StringBuilder builder = new StringBuilder() ;

        streamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
        bufferedReader = new BufferedReader(streamReader);

        try {
            String line = bufferedReader.readLine();
            while (line != null) {
                builder.append(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }

    private static URL createAPIEndpointURL(String url) {
        URL endpointURL = null;
        try {
            endpointURL = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return endpointURL;
    }
}
