package com.productschallenge.core.designsystem.param.dialog

import com.productschallenge.core.designsystem.R
import com.productschallenge.core.designsystem.param.alertdialog.SimpleDialogParam
import com.productschallenge.core.ui.R as UiRes

object NetworkErrorParam : SimpleDialogParam {
    override val iconId = R.drawable.ic_error_big
    override val titleId = R.string.error_alert_dialog_network_title
    override val textId = R.string.error_alert_dialog_network_text
    override val dismissButtonTextId = UiRes.string.close
}