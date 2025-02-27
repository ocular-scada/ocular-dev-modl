package org.ocularscada.devtools.common;

import com.inductiveautomation.ignition.common.script.hints.ScriptFunction;

public class TagScripts {

    @ScriptFunction(docBundlePrefix="TagScripts")
    public String helloWorld(String name) { return "Hello " + name; }


}
