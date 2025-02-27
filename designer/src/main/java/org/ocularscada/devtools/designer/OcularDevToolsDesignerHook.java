package org.ocularscada.devtools.designer;

import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.common.script.ScriptManager;
import com.inductiveautomation.ignition.common.script.hints.PropertiesFileDocProvider;
import com.inductiveautomation.ignition.designer.model.AbstractDesignerModuleHook;
import com.inductiveautomation.ignition.designer.model.DesignerContext;
import org.ocularscada.devtools.common.TagScripts;


/**
 * This is the Designer-scope module hook.  The minimal implementation contains a startup method.
 */
public class OcularDevToolsDesignerHook extends AbstractDesignerModuleHook {


    private DesignerContext context;

    // override additonal methods as requried

    @Override
    public void startup(DesignerContext context, LicenseState activationState) throws Exception {
        // implelement functionality as required
        this.context = context;
    }

    @Override
    public void initializeScriptManager(ScriptManager manager) {
        super.initializeScriptManager(manager);
        manager.addScriptModule("system.ocular", new TagScripts(), new PropertiesFileDocProvider());
    }
}
