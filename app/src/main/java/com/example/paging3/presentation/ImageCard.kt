package com.example.paging3.presentation

import android.provider.Settings.System.getString
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.paging3.R
import com.example.paging3.presentation.animations.TextToAnimate
import com.example.paging3.presentation.navigation.Home


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ImageCard (
    navController: NavController,
    id: Int,
    name: String,
    status: String,
    species: String,
    gender: String,
    image: String

){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,

    ) {

        Image(
            painter = painterResource(id = R.drawable.fondo ),
            contentDescription = "fondo",
            modifier =
            Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(3f / 2f)
                    .padding(16.dp)
            )
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                TextToAnimate(name)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text =  stringResource(id = R.string.status_char_es) + status,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Especie: $species",
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Género: $gender",
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Spacer(modifier = Modifier.height(8.dp))
                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    maxItemsInEachRow = 2,
                    horizontalArrangement = Arrangement.Center,

                    ) {
                    ElevatedAssistChip(
                        //border = BorderStroke(1.dp, Color.LightGray),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Home,
                                contentDescription = null
                            )
                        },
                        onClick = {
                            //navController.navigate(route = Home)
                            navController.popBackStack()
                        },
                        label = {
                            Text(text = "Volver")
                        }
                    )

                    ElevatedAssistChip(
                        //border = BorderStroke(1.dp, Color.LightGray),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Favorite,
                                contentDescription = null
                            )
                        },
                        onClick = {
                            navController.navigate(route = Home)
                        },
                        label = {
                            Text(text = "Favorito")
                        }
                    )
                }
            }
        }
    }
}