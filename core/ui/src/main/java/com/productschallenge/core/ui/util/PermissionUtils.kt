package com.productschallenge.core.ui.util

import androidx.compose.runtime.Composable
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.productschallenge.core.ui.enums.Permission

@Composable
@OptIn(ExperimentalPermissionsApi::class)
fun getMultiplePermissionState(
    permissions: List<Permission>,
    onPermissionResult: (Map<String, Boolean>) -> Unit = {}
) = rememberMultiplePermissionsState(
    permissions = permissions.map { it.manifest },
    onPermissionsResult = onPermissionResult
)
