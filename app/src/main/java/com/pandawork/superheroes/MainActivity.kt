package com.pandawork.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pandawork.superheroes.data.Hero
import com.pandawork.superheroes.data.HeroesRepository
import com.pandawork.superheroes.ui.theme.SuperHeroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperHeroTheme {
                App()
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    Scaffold(topBar = { TopAppBar() }) { it ->
        Column(
            modifier
                .padding(it)
        ) {
            LazyColumn {
                items(HeroesRepository.heroes) { hero ->
                    CardItem(hero)
                }
            }
        }
    }
}

@Composable
fun CardItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        modifier
            .height(104.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier.weight(1f), verticalArrangement = Arrangement.Center
            ) {
                HeroInformation(hero, modifier.padding(horizontal = 16.dp))
            }
            HeroImage(
                hero, modifier = Modifier
                    .padding(end = 16.dp)
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }
}

@Composable
fun HeroInformation(hero: Hero, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = stringResource(hero.nameRes),
        style = MaterialTheme.typography.titleLarge,
        fontSize = 20.sp
    )
    Text(
        modifier = modifier,
        text = stringResource(hero.descriptionRes),
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
fun HeroImage(hero: Hero, modifier: Modifier = Modifier) {
    Image(
        painterResource(hero.imageRes),
        modifier = modifier,
        contentDescription = null
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        }
    )
}


@Preview(showBackground = true)
@Composable
private fun AppPreviewLight() {
    SuperHeroTheme(darkTheme = true) {
        App()
    }
}

@Preview(showBackground = true)
@Composable
private fun AppPreviewDark() {
    SuperHeroTheme(darkTheme = false) {
        App()
    }
}