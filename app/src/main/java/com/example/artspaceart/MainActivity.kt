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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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

    var step by remember { mutableStateOf(4) }
    val imageRes: Int
    val contentDescriptionRes: Int
    val title: Int
    val artist: Int
    val year: Int

    when (step) {
        1 -> {
            imageRes = R.drawable.the_milkmaid
            contentDescriptionRes = R.string.the_milkmaid_description
            title = R.string.the_milkmaid
            artist = R.string.the_milkmaid_artist
            year = R.string.milkmaid_year
        }


        2 -> {
            imageRes = R.drawable.the_kiss
            contentDescriptionRes = R.string.the_kiss_description
            title = R.string.the_kiss_title
            artist = R.string.the_kiss_artist
            year = R.string.the_kiss_year
        }


        3 -> {
            imageRes = R.drawable.sunflwers
            contentDescriptionRes = R.string.sunflowers_description
            title = R.string.sunflowers_title
            artist = R.string.sunflowers_artist
            year = R.string.sunflowers_year
        }

        4 -> {
            imageRes = R.drawable.mona_lisa
            contentDescriptionRes = R.string.mona_lisa_description
            title = R.string.mona_lisa_title
            artist = R.string.mona_lisa_artist
            year = R.string.mona_lisa_year
        }

        else -> {
            imageRes = R.drawable.mona_lisa
            contentDescriptionRes = R.string.mona_lisa_description
            title = R.string.mona_lisa_title
            artist = R.string.mona_lisa_artist
            year = R.string.mona_lisa_year
        }
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Surface(
            modifier = Modifier
                .fillMaxHeight(0.75f)
                .wrapContentSize(Alignment.Center)
                .border(BorderStroke(3.dp, Color.White), RectangleShape)
                .shadow(15.dp),
        ) {
            ArtWorkWall(
                imageRes = imageRes,
                contentDescriptionRes = contentDescriptionRes,
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            color = Color(0xFFecebf4)
        ) {
            ArtWorkDescriptor(
                title = title,
                artist = artist,
                year = year
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        ArtWorkButtons(
            {
                if (step == 1) {
                    step = 4
                } else {
                    step--
                }
            },
            {
                if (step == 4) {
                    step = 1
                } else {
                    step++
                }
            }
        )

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
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .padding(35.dp)
    )
}

@Composable
fun ArtWorkDescriptor(
    @StringRes title: Int,
    @StringRes artist: Int,
    @StringRes year: Int,
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(
            text = stringResource(title),
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
                    append(stringResource(artist))
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp
                    )
                ) {
                    append(stringResource(year))
                }
            },
        )
    }
}

@Composable
fun ArtWorkButtons(
    onClickPrevious: () -> Unit,
    onClickNext: () -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = onClickPrevious,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF495d92)
            ),
            modifier = Modifier
                .width(140.dp)
        ) {
            Text(text = "Previous")
        }
        Button(
            onClick = onClickNext,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF495d92)
            ),
            modifier = Modifier.width(140.dp)
        ) {
            Text(text = "Next")
        }
    }
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