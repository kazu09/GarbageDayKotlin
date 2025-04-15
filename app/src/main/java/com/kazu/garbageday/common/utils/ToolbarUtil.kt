package com.kazu.garbageday.common.utils

import android.app.Activity
import android.content.Context
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import com.kazu.garbageday.R

object ToolbarUtil {

    /**
     * ツールバーにバックボタンを追加する
     *
     * @param toolbar toolbar view
     * @param isShowBackButton バックボタンを表示する : true, バックボタン非表示 : false
     * @param navController navController
     * @param context Context
     * @param title ツールバーのタイトル
     * @param backgroundColor ツールバーのバックグラウンドカラー
     * @param iconAndTextColor toolbarのアイコンとテキストの色
     */
    fun setupWithBackButton(
        toolbar: androidx.appcompat.widget.Toolbar,
        isShowBackButton: Boolean,
        navController: NavController,
        context: Context,
        title: String? = null,
        backgroundColor: Int? = null,
        iconAndTextColor: Int? = null
    ) {
        // タイトル
        title?.let { toolbar.title = it }

        // ツールバーの背景色
        backgroundColor?.let {
            setToolbarColor(toolbar, it)
        }

        // バックボタン
        if (isShowBackButton) {
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24)
            toolbar.setNavigationOnClickListener {
                // 画面を戻す
                navController.popBackStack()
            }
            iconAndTextColor?.let {
                setIconAndTextColor(toolbar, context, it)
            }
        } else {
            toolbar.navigationIcon = null
        }
    }

    /**
     * ステータスバー
     *
     * @param activity Activity
     * @param context Context
     * @param color ステータスバーカラー
     */
    fun setupStatusBar(
        activity: Activity,
        color: Int
    ) {
        val window = activity.window
        WindowCompat.setDecorFitsSystemWindows(window, true)
        window.statusBarColor = color
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true
    }

    private fun setIconAndTextColor(
        toolbar: androidx.appcompat.widget.Toolbar,
        context: Context,
        color: Int
    ) {
        val navIcon = ContextCompat.getDrawable(context, R.drawable.ic_arrow_back_black_24)
        navIcon?.setTint(color)
        toolbar.navigationIcon = navIcon
        toolbar.setTitleTextColor(color)
    }

    private fun setToolbarColor(
        toolbar: androidx.appcompat.widget.Toolbar,
        backgroundColor: Int
    ) {
        toolbar.setBackgroundColor(backgroundColor)
    }

}