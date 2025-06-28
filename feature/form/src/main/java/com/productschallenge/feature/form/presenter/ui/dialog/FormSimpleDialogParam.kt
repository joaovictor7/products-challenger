package com.productschallenge.feature.form.presenter.ui.dialog

import com.productschallenge.core.designsystem.param.alertdialog.SimpleDialogParam
import com.productschallenge.feature.form.R
import com.productschallenge.core.designsystem.R as DesignSystemRes
import com.productschallenge.core.ui.R as UiRes

internal sealed interface FormSimpleDialogParam : SimpleDialogParam {
    data object Success : SimpleDialogParam {
        override val iconId = DesignSystemRes.drawable.ic_check
        override val titleId = R.string.form_submit_success_title
        override val textId = R.string.form_submit_success_subtitle
        override val dismissButtonTextId = UiRes.string.close
    }
}