package org.ocularscada.devtools.designer

import com.inductiveautomation.ignition.designer.model.DesignerContext
import com.jidesoft.docking.DockableFrame
import org.ocularscada.devtools.common.Constants
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.awt.FlowLayout
import java.io.IOException
import javax.imageio.ImageIO
import javax.swing.*


private val logger: Logger = LoggerFactory.getLogger(Constants.SHORT_MODULE_ID)

class MyDockableTool(designerContext: DesignerContext) {

    val menuItem = JMenuItem("My Cool Tool")

    init {

        menuItem.addActionListener { ae ->
            val commandString = ae.actionCommand
            logger.info(commandString)

            // Basic JFrame popup
//            val frame = JFrame("My Cool Frame")
//            frame.contentPane.layout = FlowLayout()
//            frame.setSize(400,400)
//            frame.defaultCloseOperation = JFrame.HIDE_ON_CLOSE
//            val label = JLabel("Hello There")
//            frame.contentPane.add(label)
//            frame.isVisible = true

            // Dockable popup
            val frame = DockableFrame("My Cool Frame")
            frame.contentPane.layout = FlowLayout()
            frame.setSize(400, 400)
            frame.defaultCloseAction = DockableFrame.HIDE_ON_CLOSE
            val label = JLabel("Hello There")
            frame.contentPane.add(label)

            val dockingManager = designerContext.dockingManager
            dockingManager.addFrame(frame)

            frame.isVisible = true

        }
    }

}

