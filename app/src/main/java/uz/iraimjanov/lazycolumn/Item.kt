package uz.iraimjanov.lazycolumn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.iraimjanov.lazycolumn.model.ContactResponse

@ExperimentalMaterial3Api
@Composable
fun Item(contactResponse: ContactResponse) {
    Surface(
        color = Color.White
    ) {
        Column {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        modifier = Modifier
                            .width(32.dp)
                            .height(32.dp),
                        painter = painterResource(id = R.drawable.ic_user),
                        contentDescription = "User",
                        tint = Color.Unspecified
                    )
                    Text(
                        text = "${contactResponse.name} ${contactResponse.surname}",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 20.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        modifier = Modifier
                            .width(32.dp)
                            .height(32.dp),
                        painter = painterResource(id = R.drawable.ic_phone),
                        contentDescription = "Phone",
                        tint = Color.Unspecified,
                    )
                    Text(
                        text = contactResponse.number,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 20.sp
                    )
                }
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(0.5.dp)
                    .background(Color.DarkGray)
            )
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun ItemPreview() {
    Item(contactResponse = ContactResponse(id = 0, name = "Iqbljon", "Raimjonov", "+998906330999"))
}