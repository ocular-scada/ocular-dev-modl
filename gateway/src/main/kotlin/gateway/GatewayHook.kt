package org.ocularscada.devtools.gateway


import java.util.Optional
import com.inductiveautomation.ignition.common.licensing.LicenseState
import com.inductiveautomation.ignition.common.script.ScriptManager
import com.inductiveautomation.ignition.common.script.hints.PropertiesFileDocProvider
import com.inductiveautomation.ignition.gateway.model.AbstractGatewayModuleHook
import com.inductiveautomation.ignition.gateway.model.GatewayContext
import org.ocularscada.devtools.common.TagScripts
import org.ocularscada.devtools.common.Constants
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Suppress("unused")
class GatewayHook: AbstractGatewayModuleHook() {


    // update me with constant from common scope
    private val logger: Logger = LoggerFactory.getLogger(Constants.SHORT_MODULE_ID)
    private lateinit var context: GatewayContext;

    override fun setup(context: GatewayContext) {
        this.context = context
    }


    override fun startup(activationState: LicenseState) {
        logger.info("Ocular Dev Tools gateway hook started.")
    }


    override fun shutdown() {
        logger.info("Ocular Dev Tools gateway hook shutdown.")
    }


    override fun initializeScriptManager(manager: ScriptManager) {
        super.initializeScriptManager(manager);
        manager.addScriptModule("system.ocular", TagScripts(), PropertiesFileDocProvider());
    }

    override fun getMountedResourceFolder(): Optional<String> {
        return Optional.of("static")
    }

    override fun getMountPathAlias(): Optional<String> {
        return Optional.of(Constants.SHORT_MODULE_ID)
    }

    override fun isFreeModule(): Boolean {
        return true
    }

    override fun isMakerEditionCompatible(): Boolean {
        return true
    }



}
