package com.example.artspaceart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceart.ui.theme.ArtSpaceArtTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceArtTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SpaceArt()
                }
            }
        }
    }
}


@Composable
fun SpaceArt() {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Surface(
            modifier = Modifier
                .border(BorderStroke(3.dp, Color.White), RectangleShape)
                .shadow(15.dp),
        ) {
            ArtWorkWall(
                imageRes = R.drawable.the_milkmaid,
                contentDescriptionRes = R.string.the_milkmaid_description,
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            color = Color(0xFFecebf4)
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Text(
                    text = stringResource(R.string.the_milkmaid),
                    textAlign = TextAlign.Right,
                    fontSize = 24.sp
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        ) {
                            append(stringResource(R.string.jan_vermeer))
                        }
                        withStyle(
                            style = SpanStyle(
                                fontSize = 16.sp
                            )
                        ) {
                            append(stringResource(R.string.milkmaid_year))
                        }
                    },
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF495d92)
                ),
                modifier = Modifier
                    .width(140.dp)
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF495d92)
                ),
                modifier = Modifier.width(140.dp)
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Composable
fun ArtWorkWall(
    @DrawableRes imageRes: Int,
    @StringRes contentDescriptionRes: Int,
) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = stringResource(id = contentDescriptionRes),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(35.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun ArtPreview() {
    ArtSpaceArtTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            SpaceArt()
        }
    }
}