package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                    contentColor = Color.Black
                ) {
                    ProfileCard()
                }
            }
        }
    }
}

@Composable
fun ProfileCard () {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFd2e8d4))
    ) {
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(5f)
        ) {
            ProfessionalProfile(
                picture = painterResource(id = R.drawable.android_logo),
                fullName = stringResource(id = R.string.username),
                title = stringResource(id = R.string.job)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            ContactDetails()
        }
    }
}

@Composable
fun ProfessionalProfile (
    picture: Painter,
    fullName: String,
    title: String,
    modifier: Modifier = Modifier
){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = picture,
            contentDescription = null,
            modifier = modifier
                .height(120.dp)
                .width(120.dp)
                .background(color = Color(0xFF073042))
        )
        Box {

        }
        Text(
            text = fullName,
            fontSize = 30.sp,
            fontWeight = FontWeight.Light,
            modifier = modifier.padding(4.dp)
        )
        Text(
            text = title,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3ddc84)
        )
    }
}

@Composable
fun Contact (
    icon: ImageVector,
    label: String,
    modifier: Modifier = Modifier
){
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = Color(0xFF3ddc84),
            modifier = modifier
                .height(18.dp)
        )
        Text(
            text = label,
            fontSize = 12.sp,
            modifier = modifier
                .padding(start =  12.dp, end = 12.dp, top = 8.dp, bottom = 8.dp)
            )
    }
}

@Composable
fun ContactDetails (){
    Column {
        Contact(
            icon = Icons.Default.Call,
            label = stringResource(id = R.string.phone)
        )
        Contact(
            icon = Icons.Default.Share,
            label = "@" + stringResource(id = R.string.share)
        )
        Contact(
            icon = Icons.Default.Email,
            label = stringResource(id = R.string.email)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        ProfileCard()
    }
}