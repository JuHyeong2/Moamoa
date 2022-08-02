package com.side.moamoa.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.side.moamoa.ui.analytics.AnalyticsScreen
import com.side.moamoa.ui.calendar.CalendarScreen
import com.side.moamoa.ui.home.HomeScreen
import com.side.moamoa.ui.my_page.MyPageScreen
import com.side.moamoa.ui.navigation.*
import com.side.moamoa.ui.theme.AppBackgroundColor
import com.side.moamoa.ui.theme.AppMainColor
import com.side.moamoa.ui.theme.MoamoaTheme
import com.side.moamoa.ui.theme.NavUnselectedColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoamoaTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(bottomBar = { AppBottomNavigation(navController = navController) }) {
        NavHost(navController = navController, startDestination = NAV_HOME) {
            composable(NAV_HOME) { HomeScreen() }
            composable(NAV_CALENDAR) { CalendarScreen() }
            composable(NAV_ANALYTICS) { AnalyticsScreen() }
            composable(NAV_MY_PAGE) { MyPageScreen() }
        }
    }
}

@Composable
fun AppBottomNavigation(navController: NavController) {
    val navItem = listOf(
        BottomNavItem.Home,
        BottomNavItem.Calendar,
        BottomNavItem.Analytics,
        BottomNavItem.MyPage
    )

    BottomNavigation(
        backgroundColor = AppBackgroundColor,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItem.forEach { item ->
            val idSelected = currentRoute == item.route

            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = when (idSelected) {
                            true -> painterResource(id = item.selectedIcon)
                            false -> painterResource(id = item.unselectedIcon)
                        },
                        contentDescription = stringResource(
                            id = item.title
                        )
                    )
                },
                selectedContentColor = AppMainColor,
                unselectedContentColor = NavUnselectedColor,
                selected = idSelected,
                onClick = {
                    navController.popBackStack()
                    navController.navigate(item.route)
                })
        }
    }
}