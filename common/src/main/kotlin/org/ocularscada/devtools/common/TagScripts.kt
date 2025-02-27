package org.ocularscada.devtools.common

import com.inductiveautomation.ignition.common.script.hints.ScriptFunction

class TagScripts {

    @ScriptFunction(docBundlePrefix="TagScripts")
    fun helloWorld(name: String): String {
        return "Hello there $name"
    }


}
