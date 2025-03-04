package org.ocularscada.devtools.designer

import com.inductiveautomation.ignition.common.licensing.LicenseState
import com.inductiveautomation.ignition.common.script.ScriptManager
import com.inductiveautomation.ignition.common.script.hints.PropertiesFileDocProvider
import com.inductiveautomation.ignition.designer.model.AbstractDesignerModuleHook
import com.inductiveautomation.ignition.designer.model.DesignerContext
import com.inductiveautomation.ignition.designer.model.menu.JMenuMerge
import com.inductiveautomation.ignition.designer.model.menu.MenuBarMerge
import com.inductiveautomation.ignition.designer.model.menu.WellKnownMenuConstants
import org.ocularscada.devtools.common.TagScripts
import org.ocularscada.devtools.common.Constants
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.swing.JFrame
import javax.swing.JMenu
import javax.swing.JMenuItem

@Suppress("unused")
class DesignerHook: AbstractDesignerModuleHook() {

    private val logger: Logger = LoggerFactory.getLogger(Constants.SHORT_MODULE_ID)
    private lateinit var context: DesignerContext;

    override fun startup(context: DesignerContext, activationState: LicenseState ) {
        this.context = context

    }

    override fun  initializeScriptManager(manager: ScriptManager) {
        super.initializeScriptManager(manager);
        manager.addScriptModule("system.ocular", TagScripts(), PropertiesFileDocProvider());
    }

    override fun getModuleMenu(): MenuBarMerge {

        val menuBarMerge = MenuBarMerge(Constants.SHORT_MODULE_ID)
        val toolsMenuMerge = JMenuMerge(WellKnownMenuConstants.TOOLS_MENU_NAME)
        val toolMenuItem = MyDockableTool(context).menuItem
        toolsMenuMerge.add(toolMenuItem)
        menuBarMerge.add(WellKnownMenuConstants.TOOLS_MENU_LOCATION, toolsMenuMerge)
        return menuBarMerge

    }


}
