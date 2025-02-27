package org.ocularscada.devtools.designer

import com.inductiveautomation.ignition.common.licensing.LicenseState
import com.inductiveautomation.ignition.common.script.ScriptManager
import com.inductiveautomation.ignition.common.script.hints.PropertiesFileDocProvider
import com.inductiveautomation.ignition.designer.model.AbstractDesignerModuleHook
import com.inductiveautomation.ignition.designer.model.DesignerContext
import org.ocularscada.devtools.common.TagScripts
import org.ocularscada.devtools.common.Constants
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Suppress("unused")
class DesignerHook: AbstractDesignerModuleHook() {

    private val logger: Logger = LoggerFactory.getLogger(Constants.SHORT_MODULE_ID)
    private lateinit var context: DesignerContext;

    override fun startup(context: DesignerContext, activationState: LicenseState ) {
        this.context = context;
    }

    override fun  initializeScriptManager(manager: ScriptManager) {
        super.initializeScriptManager(manager);
        manager.addScriptModule("system.ocular", TagScripts(), PropertiesFileDocProvider());
    }
}
