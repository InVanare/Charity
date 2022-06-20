package pl.coderslab.charity.utility;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

@Component
public class Template {

    private Configuration configuration;

    @Autowired
    public Template(Configuration configuration) {
        this.configuration = configuration;
    }

    //nameTemplate: only filename and extension (e.g. email.ftlh)
    public String getContentFromTemplate(String nameTemplate, Map<String, Object> model) throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter();
        configuration.getTemplate(nameTemplate).process(model, stringWriter);
        return stringWriter.getBuffer().toString();
    }
}
