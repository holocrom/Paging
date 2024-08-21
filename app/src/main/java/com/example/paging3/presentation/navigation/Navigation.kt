package com.example.paging3.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.paging3.presentation.ImageCard
import com.example.paging3.presentation.RickListScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home){
        composable<Home>{
            RickListScreen(navController)
        }
        composable<Detail> {
            val detail = it.toRoute<Detail>()
            ImageCard(navController = navController,  id=detail.id, name = detail.name, status = detail.status, species = detail.species, gender = detail.gender, image = detail.image)
        }
    }
}