package utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Parses entity to json and vice versa
 * using Jackson's ObjectMapper
 *
 * 
 */
public class RequestIOUtils
{
    private RequestIOUtils()
    {
    }

    /**
     * parse the given entity to JSON then write it to the response's output stream
     *
     * @param resp   the response
     * @param object the entity
     * @throws IOException if there is an error with the stream
     */
    public static void writeJSONResp(HttpServletResponse resp, Object object) throws IOException
    {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(out, object);

        final byte[] data = out.toByteArray();

        PrintWriter respOut = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        respOut.print(new String(data));
        respOut.flush();
    }

    /**
     * parse the servlet request's to entity
     *
     * @param req         the request with the json data
     * @param objectClass the class of the expected entity
     * @param <T>         the entity type
     * @return the parsed entity
     * @throws IOException if there is a problem with request's BufferedReader
     */
    public static <T> T parseJSONtoObject(HttpServletRequest req, Class<T> objectClass) throws IOException
    {
        BufferedReader r = req.getReader();
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = r.readLine()) != null)
        {
            sb.append(line);
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);

        return mapper.readValue(sb.toString(), objectClass);
    }
}