package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonTextImage()
                }
            }
        }
    }
}
@Preview
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonTextImage()
    }
}

@Composable
fun LemonTextImage(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize())
{
    var result by remember { mutableStateOf(1) }
    var clicker by remember { mutableStateOf(1) }
    clicker = (2..10).random()

    val imageResource = when (result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val textLabelResourceId = when (result) {
        1 -> R.string.tree
        2 -> R.string.squeeze
        3 -> R.string.drink
        else -> R.string.empty
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(stringResource(textLabelResourceId),
            fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(imageResource),
            contentDescription = textLabelResourceId.toString(),
            modifier = modifier
                .wrapContentSize()
                .clickable ( onClick = {

                    if(result == 2 && clicker != 0){
                        clicker--
                    }else result++


                } )
                .border(BorderStroke(2.dp, Color(105, 205, 216)),
                    shape = RoundedCornerShape(4.dp))
                .padding(16.dp)

        )
    if (result == 5) result = 1
    }
}

