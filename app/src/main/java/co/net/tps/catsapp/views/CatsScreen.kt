package co.net.tps.catsapp.views

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


@Composable
fun CatsScreen(catsScreenViewModel: CatsScreenViewModel){




    val cats: ArrayList<Cat> by catsScreenViewModel.cats.observeAsState(arrayListOf())
    catsScreenViewModel.getCats()
    if(cats.size == 0){
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            CircularProgressIndicator(
                color = Color.Blue
            )
        }

    }else{
        Column() {
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                Text(
                    modifier = Modifier.padding(top = 30.dp),
                    text = "CatBreeds",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )
            }

            Box(modifier = Modifier.padding(20.dp)){
                LazyColumn {

                    cats.forEach { cat ->
                        item {
                            Card(
                                shape = RoundedCornerShape(30.dp),
                                border = BorderStroke(2.dp, Color.Blue),
                                modifier = Modifier.padding(30.dp)
                            ) {
                                Column() {
                                    Text(
                                        modifier = Modifier.padding(top = 30.dp, start = 30.dp, bottom = 10.dp),
                                        text = "${cat.getName()}",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black,
                                    )
                                    Log.d("yamid", "${cat.getImage()}")
                                    AsyncImage(
                                        model = "https://cdn2.thecatapi.com/images/${cat.getImage()}.jpg",
                                        contentDescription = "Translated description of what the image contains"
                                    )
                                    Row(
                                        Modifier
                                            .fillMaxWidth()
                                            .padding(start = 30.dp, bottom = 30.dp)) {
                                        Text(
                                            modifier = Modifier.padding(top = 30.dp),
                                            text = "País de origen: ",
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Black,
                                        )
                                        Spacer(modifier = Modifier.width(3.dp))
                                        Text(
                                            modifier = Modifier.padding(top = 30.dp),
                                            text = "${cat.getOrigin()}",
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Black,
                                        )
                                        Spacer(modifier = Modifier.width(30.dp))
                                        Text(
                                            modifier = Modifier.padding(top = 30.dp),
                                            text = "Inteligencia: ",
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Black,
                                        )
                                        Spacer(modifier = Modifier.width(3.dp))
                                        Text(
                                            modifier = Modifier.padding(top = 30.dp),
                                            text = "${cat.getIntelligence()}",
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Black,
                                        )
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }


        Log.d("yamid", "Si hay gatos")
    }
}