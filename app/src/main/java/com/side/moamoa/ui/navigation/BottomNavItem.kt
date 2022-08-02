package com.side.moamoa.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.side.moamoa.R

sealed class BottomNavItem(
    @StringRes val title: Int,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    val route: String
) {
    object Home : BottomNavItem(
        title = R.string.navigation_title_home,
        selectedIcon = R.drawable.home_selected,
        unselectedIcon = R.drawable.home_unselected,
        route = NAV_HOME
    )

    object Calendar : BottomNavItem(
        title = R.string.navigation_title_calendar,
        selectedIcon = R.drawable.calendar_selected,
        unselectedIcon = R.drawable.calendar_unselected,
        route = NAV_CALENDAR
    )

    object Analytics : BottomNavItem(
        title = R.string.navigation_title_analytics,
        selectedIcon = R.drawable.analytics_selected,
        unselectedIcon = R.drawable.analytics_unselected,
        route = NAV_ANALYTICS
    )

    object MyPage : BottomNavItem(
        title = R.string.navigation_title_my_page,
        selectedIcon = R.drawable.my_page_selected,
        unselectedIcon = R.drawable.my_page_unselected,
        route = NAV_MY_PAGE
    )
}
