package com.productschallenge.core.designsystem.param.dialog

import com.productschallenge.core.designsystem.R
import com.productschallenge.core.designsystem.param.alertdialog.SimpleDialogParam
import com.productschallenge.core.ui.R as UiRes

object GenericErrorParam : SimpleDialogParam {
    override val iconId = R.drawable.ic_error_big
    override val titleId = R.string.error_alert_dialog_generic_title
    override val textId = R.string.error_alert_dialog_generic_text
    override val dismissButtonTextId = UiRes.string.close
}