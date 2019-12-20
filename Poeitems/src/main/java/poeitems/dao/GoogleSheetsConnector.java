/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poeitems.dao;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Class connects to the Google API and authenticates the connection to the wanted Google Sheet.
 */
public class GoogleSheetsConnector {

    private static Sheets sheetsService;
    private static String applicationName = "Google Sheets Example";
    private static String spreadsheetId = "1unsZDU8xOI8WzlafIW9i5NZmBeta4U19rcVJobJkvGU";
    
    /**
    *
    *Reads the authentication data from credential json and creates authorised connection to the Google API.
    *
    */
    private static Credential authorize() throws IOException, GeneralSecurityException, Exception {
        InputStream in = GoogleSheetsConnector.class.getResourceAsStream("/credentials.json");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
                JacksonFactory.getDefaultInstance(), new InputStreamReader(in)
        );

        List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(GoogleNetHttpTransport.newTrustedTransport(),
                JacksonFactory.getDefaultInstance(), clientSecrets, scopes)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File("tokens")))
                .setAccessType("offline")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(
                flow, new LocalServerReceiver())
                .authorize("user");

        return credential;
    }

    /**
     *
     * @return
     * @throws IOException
     * @throws GeneralSecurityException
     * @throws Exception
     * 
     * Generates connection to the Sheets API.
     */
    public static Sheets getSheetsService() throws IOException, GeneralSecurityException, Exception {
        Credential credential = authorize();

        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(),
                JacksonFactory.getDefaultInstance(), credential)
                .setApplicationName(applicationName)
                .build();
    }

    /**
     *
     * @return
     * @throws java.security.GeneralSecurityException
     * 
     * Reads data from the given sheet.
     */
    public static List readDataSheets() throws Exception {

        sheetsService = getSheetsService();
        String range = "A2:E100";

        ValueRange response = sheetsService.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();

        List<List<Object>> values = response.getValues();

        return values;
    }
    
    /**
     *
     * @param type
     * @param name
     * @param divCard
     * @param map
     * @param area
     * @throws IOException
     * @throws Exception
     */
    
    /*
    *
    *Adds a row to the sheet with given parameters.
    *
    */
    public static void writeToDataSheets(String type, String name, String divCard, String map, String area) throws IOException, Exception {
        
        sheetsService = getSheetsService();
        String range = "A2:E100";
        
        
        ValueRange appendBody = new ValueRange()
                .setValues(Arrays.asList(
                        Arrays.asList(type, name, divCard, map, area)
                ));
        
        AppendValuesResponse appendresult = sheetsService.spreadsheets().values()
                .append(spreadsheetId, range, appendBody)
                .setValueInputOption("USER_ENTERED")
                .setInsertDataOption("INSERT_ROWS")
                .setIncludeValuesInResponse(Boolean.TRUE)
                .execute();
    }

}
