package com.tencent.xml;

import java.io.Writer;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.naming.NameCoder;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;

public class WXDomDriver extends DomDriver {

    public WXDomDriver(String encoding, NameCoder nameCoder) {

        super(encoding, nameCoder);
    }

    public HierarchicalStreamWriter createWriter(Writer out) {

        return new PrettyPrintWriter(out, getNameCoder()) {

            @Override
            protected void writeText(QuickWriter writer, String text) {

                writer.write("<![CDATA[");
                writer.write(text);
                writer.write("]]>");
            }
        };
    }
}
