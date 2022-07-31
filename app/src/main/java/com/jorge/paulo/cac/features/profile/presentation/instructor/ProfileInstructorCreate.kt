package com.jorge.paulo.cac.features.profile.presentation.instructor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.R
import com.jorge.paulo.cac.core.commom.ui.components.AppAnimated
import com.jorge.paulo.cac.core.commom.ui.components.AppBottomBar
import com.jorge.paulo.cac.core.commom.ui.components.AppButtonList
import com.jorge.paulo.cac.core.commom.ui.components.AppButtons
import com.jorge.paulo.cac.core.commom.ui.components.AppContentModal
import com.jorge.paulo.cac.core.commom.ui.components.AppDivider
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppIcons
import com.jorge.paulo.cac.core.commom.ui.components.AppInputDefault
import com.jorge.paulo.cac.core.commom.ui.components.AppSectionContact
import com.jorge.paulo.cac.core.commom.ui.components.AppSectionMidia
import com.jorge.paulo.cac.core.commom.ui.components.AppSectionWrapper
import com.jorge.paulo.cac.core.commom.ui.components.AppSpace
import com.jorge.paulo.cac.core.commom.ui.components.AppSpaceList
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.components.AppToolbar
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Green
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Red700
import com.jorge.paulo.cac.core.commom.ui.theme.White
import com.jorge.paulo.cac.features.commom.Course
import com.jorge.paulo.cac.features.commom.EditCourse
import com.jorge.paulo.cac.features.profile.presentation.cac.Certificate
import com.jorge.paulo.cac.features.store.fragments.TypeModal
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfileInstructorCreate() {

    val showSectionOptions = remember { mutableStateOf(false) }
    val showSectionData = remember { mutableStateOf(false) }
    val showSectionDocument = remember { mutableStateOf(false) }
    val showSectionAccess = remember { mutableStateOf(false) }
    val showSectionMidia = remember { mutableStateOf(false) }
    val showSectionContact = remember { mutableStateOf(false) }
    val courseVisible = remember { mutableStateOf(false) }
    val certificateVisible = remember { mutableStateOf(false) }
    val homeVisible = remember { mutableStateOf(true) }
    val editCourseVisible = remember { mutableStateOf(false) }
    val animationTime = 300
    val type = remember { mutableStateOf(TypeModal.NONE) }
    val state = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()


    AppAnimated(
        editCourseVisible.value,
        animationTime,
    ) {
        EditCourse {
            courseVisible.value = true
            editCourseVisible.value = false
        }
    }

    AppAnimated(
        courseVisible.value,
        animationTime,
    ) {
        Course(
            onClickBack = {
                homeVisible.value = true
                courseVisible.value = false
            },
            onNavigate = {
                courseVisible.value = false
                editCourseVisible.value = true
            }
        )
    }

    AppAnimated(
        certificateVisible.value,
        animationTime,
    ) {
        Certificate() {
            homeVisible.value = true
            certificateVisible.value = false
        }
    }
    AppAnimated(
        homeVisible.value,
        animationTime,
    ) {
        Scaffold(
            topBar = {
                AppToolbar(
                    modifier = Modifier.fillMaxWidth(),
                    onBack = {
                    },
                    title = "Profile Instrutor"
                )
            },
            bottomBar = {
                AppBottomBar(
                    onDeleteClick = {
                        type.value = TypeModal.DELETE
                        scope.launch { state.show() }
                    }) {
                    type.value = TypeModal.LOGOUT
                    scope.launch { state.show() }
                }
            }

        ) {
            ModalBottomSheetLayout(
                sheetState = state,
                sheetBackgroundColor = Black,
                scrimColor = Black.copy(alpha = .6f),
                sheetContent = {
                    when (type.value) {
                        TypeModal.DELETE -> {
                            AppContentModal(
                                "Deletar Conta",
                                "Você tem certeza que deseja deletar sua conta?  Após executar esta ação não poderemos recuperar os dados.",
                                "DELETAR",
                                onActionClick = {

                                },
                                onCloseClick = {
                                    type.value = TypeModal.NONE
                                    scope.launch { state.hide() }
                                }
                            )
                        }
                        else -> {
                            AppContentModal(
                                "Deslogar",
                                "Você deseja deslogar do app? Para retornar ao seu dashboard será necessário fazer o login, novamente.",
                                "OK, DESLOGAR",
                                colorButton = Green,
                                onActionClick = {

                                },
                                onCloseClick = {
                                    type.value = TypeModal.NONE
                                    scope.launch { state.hide() }
                                }
                            )
                        }
                    }
                }
            ) {
                LazyColumn(
                    Modifier
                        .padding(
                            start = 10.dp,
                            end = 10.dp,
                            bottom = it.calculateBottomPadding()
                        )
                ) {
                    item {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .size(200.dp)
                                    .clickable { },
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.placehold_image),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )
                                Box(
                                    modifier = Modifier
                                        .padding(
                                            top = 110.dp,
                                            start = 170.dp
                                        )
                                        .clip(RoundedCornerShape(30))
                                        .background(Black)
                                        .padding(5.dp)
                                ) {
                                    AppIcons(appIcons = AppIconList.CAMERA, color = White)
                                }

                            }
                        }
                    }
                    item {

                        AppSectionWrapper(
                            titleSection = "Menu",
                            isShow = showSectionOptions.value,
                            onShow = { showSectionOptions.value = !showSectionOptions.value },
                            hasButton = false
                        ) {
                            AppButtons(
                                colorButton = Color.Transparent,
                                modifier = Modifier
                                    .padding(bottom = 5.dp),
                                label = "Meus Certificados",
                                colorLabel = LightGray,
                                appButtons = AppButtonList.DEFAULT,
                                onClick = {
                                    certificateVisible.value = true
                                    homeVisible.value = false
                                },
                            )
                            AppButtons(
                                colorButton = Color.Transparent,
                                modifier = Modifier
                                    .padding(bottom = 5.dp),
                                label = "Cursos que ministro",
                                colorLabel = LightGray,
                                appButtons = AppButtonList.DEFAULT, onClick = {
                                    courseVisible.value = true
                                    homeVisible.value = false
                                }
                            )


                        }
                    }
                    item {
                        AppSpace(appSizes = AppSpaceList.MEDIUM)
                        AppSectionWrapper(
                            titleSection = "Dados Pessoais",
                            isShow = showSectionData.value,
                            onShow = { showSectionData.value = !showSectionData.value }) {
                            AppInputDefault(
                                modifier = Modifier.padding(bottom = 15.dp),
                                onValueChange = {},
                                value = "digite seu nome",
                                label = "Nome completo"
                            )
                            AppInputDefault(
                                modifier = Modifier.padding(bottom = 15.dp),
                                onValueChange = {},
                                value = "digite seu CPF",
                                keyboardType = KeyboardType.Number,
                                label = "CPF"
                            )

                        }
                    }
                    item {
                        AppSpace(appSizes = AppSpaceList.MEDIUM)
                        AppSectionWrapper(
                            titleSection = "Sobre mim",
                            isShow = showSectionDocument.value,
                            onShow = { showSectionDocument.value = !showSectionDocument.value }) {

                            AppInputDefault(
                                modifier = Modifier
                                    .height(185.dp)
                                    .padding(bottom = 15.dp),
                                singleLine = false,
                                onValueChange = {},
                                value = "fale o que achas necessario que os outros saibam, estes dados difam público",
                                label = "Sobre mim"
                            )
                        }
                    }
                    item {
                        AppSpace(appSizes = AppSpaceList.MEDIUM)
                        AppSectionContact(
                            onShow = {
                                showSectionContact.value = !showSectionContact.value
                            },
                            isShow = showSectionContact.value
                        ) {}
                    }
                    item {
                        AppSpace(appSizes = AppSpaceList.MEDIUM)
                        AppSectionMidia(
                            onShow = {
                                showSectionMidia.value = !showSectionMidia.value
                            },
                            isShow = showSectionMidia.value
                        ) {}
                    }
                    item {
                        AppSpace(appSizes = AppSpaceList.MEDIUM)
                        AppSectionWrapper(
                            titleSection = "Dados de acesso",
                            isShow = showSectionAccess.value,
                            onShow = { showSectionAccess.value = !showSectionAccess.value }) {
                            AppInputDefault(
                                modifier = Modifier.padding(bottom = 15.dp),
                                onValueChange = {},
                                value = "Email",
                                keyboardType = KeyboardType.Email,
                                label = "email@email.com"
                            )
                            AppInputDefault(
                                modifier = Modifier.padding(bottom = 15.dp),
                                onValueChange = {},
                                value = "Senha",
                                keyboardType = KeyboardType.Password,
                                label = "digite uma nova senha"
                            )
                            AppInputDefault(
                                modifier = Modifier.padding(bottom = 15.dp),
                                onValueChange = {},
                                value = "Rep. Senha",
                                keyboardType = KeyboardType.Password,
                                label = "repita a senha"
                            )
                        }
                    }
                    item {
                        AppSpace(appSizes = AppSpaceList.LARGE)
                    }
                }

            }
        }
    }
}


