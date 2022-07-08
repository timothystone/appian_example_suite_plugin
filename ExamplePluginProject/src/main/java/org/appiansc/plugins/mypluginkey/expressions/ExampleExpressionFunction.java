package org.appiansc.plugins.mypluginkey.expressions;

import com.appiancorp.ps.plugins.typetransformer.AppianObject;
import com.appiancorp.ps.plugins.typetransformer.AppianTypeFactory;
import org.appiansc.plugins.mypluginkey.MyPluginCategory;
import com.appiancorp.suiteapi.content.ContentService;
import com.appiancorp.suiteapi.expression.annotations.Function;
import com.appiancorp.suiteapi.expression.annotations.Parameter;
import com.appiancorp.suiteapi.knowledge.DocumentDataType;
import com.appiancorp.suiteapi.type.AppianType;
import com.appiancorp.suiteapi.type.TypeService;
import com.appiancorp.suiteapi.type.TypedValue;
import org.apache.log4j.Logger;

import java.sql.Timestamp;


@MyPluginCategory
public class ExampleExpressionFunction {
    private static final Logger LOG = Logger.getLogger(ExampleExpressionFunction.class);

    @Function
    public TypedValue exampleExpressionFunction(
            TypeService typeService,           // injected dependency
            ContentService contentService,     // injected dependency
            @Parameter Timestamp someDateTime,
            @Parameter @DocumentDataType Long someDocument,
            @Parameter(required = false) String... optionalListOfStrings
    ) {
        LOG.debug("exampleExpressionFunction was called; create a dictionary and return it");

        if (optionalListOfStrings != null)
            LOG.info("optionalListOfStrings was " + optionalListOfStrings.length + " items");

        AppianTypeFactory typeFactory = AppianTypeFactory.newInstance(typeService);
        AppianObject dictionary = (AppianObject) typeFactory.createElement(AppianType.DICTIONARY);

        dictionary.put("someDateTime", typeFactory.createDateTime(someDateTime));
        dictionary.put("someDocumentId", typeFactory.createLong(someDocument));

        return typeFactory.toTypedValue(dictionary);
    }
}