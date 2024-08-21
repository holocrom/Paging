package com.example.paging3.presentation

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.example.paging3.presentation.animations.TextToAnimate
import com.example.paging3.presentation.model.CharacterModel
import com.example.paging3.presentation.navigation.Detail

@Composable
fun RickListScreen(
    navController: NavController,
    rickListViewModel: RickListViewModel = hiltViewModel()){

    val characters = rickListViewModel.characters.collectAsLazyPagingItems()


    Box(
        modifier =
        Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ){
        when{
            characters.loadState.refresh is LoadState.Loading && characters.itemCount == 0 -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ){
                    CircularProgressIndicator(
                        modifier =
                        Modifier.size(64.dp),
                        color = Color.White
                    )
                }
            }

            //empty state
            characters.loadState.refresh is LoadState.NotLoading && characters.itemCount == 0 ->{
                Text(text = "Sin personajes, aún...")
            }
            //some sort of error
            characters.loadState.hasError ->{
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red),
                    contentAlignment = Alignment.Center){
                    Text(text = "Error en la carga")
                }
            }

            //else
            else -> {
                CharacterList(navController,characters = characters)
                if(characters.loadState.append is LoadState.Loading){
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    ){
                        CircularProgressIndicator(
                            modifier = Modifier.size(64.dp),
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CharacterList(
    navController: NavController,
    characters:LazyPagingItems<CharacterModel>){

    LazyColumn{
        items (characters.itemCount){
            characters[it]?.let { characterModel->
                ItemList(characterModel, navController)
            }
        }
    }
}

@Composable
fun ItemList(characterModel: CharacterModel,
             navController: NavController) {
    Box(
        modifier =
        Modifier
            .padding(20.dp)
            .clip(RoundedCornerShape(8, 8, 0, 8))
            .height(300.dp)
            .clickable {
                navController.navigate(
                    route = Detail(characterModel.id, characterModel.name, characterModel.status, characterModel.species, characterModel.gender,characterModel.image)
                )
            }
        ,
        contentAlignment = Alignment.BottomCenter
    ){
        AsyncImage(
            model = characterModel.image,
            contentDescription = "character image",
            modifier =
            Modifier
                .padding(0.dp, 0.dp, 0.dp, 60.dp)
                .clip(RoundedCornerShape(0, 0, 6, 6))
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        TextToAnimate(characterModel.name)
    }
}

