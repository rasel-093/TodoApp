package com.example.todoapp.components

//@Composable
//fun HeaderCard() {

//    var currentDate by remember {
//        mutableStateOf(LocalDate.now())
//    }
//    var currentTime by remember {
//        mutableStateOf(LocalTime.now())
//    }
//    LaunchedEffect(Unit) {
//        while (true) {
//            delay(1000)
//            currentDate = LocalDate.now()
//            currentTime = LocalTime.now()
//        }
//    }
//    val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
//    var formattedCurrentDate = currentDate.format(dateFormatter)
//
//    val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")
//    var formattedTime = currentTime.format(timeFormatter)

//    ElevatedCard(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clip(RoundedCornerShape(8.dp)),
//        colors = CardDefaults.cardColors(
//            containerColor = Color(0xFFFFFFFF)
//        )
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(5.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            BoldText(text = "Your Tasks")
//            Row(
//                horizontalArrangement = Arrangement.SpaceBetween,
//                modifier = Modifier
//                    .fillMaxWidth(0.6f)
//            ) {
//                BoldText(text = formattedCurrentDate.toString())
//                BoldText(text = formattedTime.toString())
//            }
//        }
//        val filterItems = arrayListOf("Today", "Tomorrow", "Missed", "Done")
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .horizontalScroll(rememberScrollState())
//        ) {
//            filterItems.forEach{btnText->
//                TextButton(
//                    modifier = Modifier
//                        .padding(start = 8.dp)
//                        .clip(RoundedCornerShape(8.dp))
//                        .background(Color.LightGray),
//                    onClick = {
//
//                }) {
//                    Text(text = btnText)
//                }
//            }
//        }
//    }
//}