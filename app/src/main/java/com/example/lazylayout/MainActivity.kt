package com.example.lazylayout

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.lazylayout.ui.theme.LazyLayoutTheme

class MainActivity : ComponentActivity() {

    val gadgets = listOf(
        Gadget(
            1,
            "Smartphone",
            "Perangkat komunikasi genggam",
            R.drawable.smartphone
        ),
        Gadget(
            2,
            "Laptop",
            "Komputer portabel untuk bekerja",
            R.drawable.laptop
        ),
        Gadget(
            3,
            "Tablet",
            "Perangkat layar sentuh antara hp dan laptop",
            R.drawable.tablet
        ),
        Gadget(
            4,
            "Smartwatch",
            "Jam tangan pintar pelacak kesehatan",
            R.drawable.smartwatch
        ),
        Gadget(
            5,
            "Earbuds",
            "Perangkat audio nirkabel",
            R.drawable.earbuds
        ),
        Gadget(
            6,
            "Laptop",
            "Perangkat komputasi portabel",
            R.drawable.laptop
        ),
        Gadget(
            7,
            "Smartphone",
            "Perangkat komunikasi genggam",
            R.drawable.smartphone
        ),
        Gadget(
            8,
            "Laptop",
            "Komputer portabel untuk bekerja",
            R.drawable.laptop
        ),
        Gadget(
            9,
            "Tablet",
            "Perangkat layar sentuh antara hp dan laptop",
            R.drawable.tablet
        ),
        Gadget(
            10,
            "Smartwatch",
            "Jam tangan pintar pelacak kesehatan",
            R.drawable.smartwatch
        ),
        Gadget(
            11,
            "Earbuds",
            "Perangkat audio nirkabel",
            R.drawable.earbuds
        ),
        Gadget(
            12,
            "Laptop",
            "Perangkat komputasi portabel",
            R.drawable.laptop
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            LazyLayoutTheme {
                GadgetScreen(gadgets)
            }
        }
    }
}

@Composable
fun GadgetScreen(gadgets: List<Gadget>) {

    val configuration = LocalConfiguration.current

    val isLandscape =
        configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    val columnCount = if (isLandscape) {
        4
    } else {
        2
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFF7F1E8),
        contentWindowInsets = WindowInsets.statusBars
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Text(
                text = "NIM: 245150400111027",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 8.dp,
                    end = 16.dp
                )
            )

            Text(
                text = "Nama: Dania Pujiarum Nafisah",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 4.dp,
                    end = 16.dp,
                    bottom = 8.dp
                )
            )

            GadgetGrid(
                gadgets = gadgets,
                columnCount = columnCount
            )
        }
    }
}

@Composable
fun GadgetGrid(
    gadgets: List<Gadget>,
    columnCount: Int
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(columnCount),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            start = 8.dp,
            end = 8.dp,
            bottom = 16.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        items(gadgets) { gadget ->
            GadgetItem(gadget)
        }
    }
}

@Composable
fun GadgetItem(gadget: Gadget) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(115.dp)
                    .background(Color.White)
            ) {

                Image(
                    painter = painterResource(
                        id = gadget.imageRes
                    ),
                    contentDescription = gadget.name,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                Text(
                    text = gadget.name,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = gadget.description,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}