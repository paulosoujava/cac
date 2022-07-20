package com.jorge.paulo.cac.features.about

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jorge.paulo.cac.R
import com.jorge.paulo.cac.core.commom.ui.components.AppBackground
import com.jorge.paulo.cac.core.commom.ui.components.AppDivider
import com.jorge.paulo.cac.core.commom.ui.components.AppIconList
import com.jorge.paulo.cac.core.commom.ui.components.AppIcons
import com.jorge.paulo.cac.core.commom.ui.components.AppMidia
import com.jorge.paulo.cac.core.commom.ui.components.AppSpace
import com.jorge.paulo.cac.core.commom.ui.components.AppSpaceList
import com.jorge.paulo.cac.core.commom.ui.components.AppText
import com.jorge.paulo.cac.core.commom.ui.components.AppTextList
import com.jorge.paulo.cac.core.commom.ui.components.AppToolbar
import com.jorge.paulo.cac.core.commom.ui.theme.Black
import com.jorge.paulo.cac.core.commom.ui.theme.Black50
import com.jorge.paulo.cac.core.commom.ui.theme.CacTheme
import com.jorge.paulo.cac.core.commom.ui.theme.Elevations
import com.jorge.paulo.cac.core.commom.ui.theme.LightGray
import com.jorge.paulo.cac.core.commom.ui.theme.Orange
import com.jorge.paulo.cac.core.commom.ui.theme.Shapes
import com.jorge.paulo.cac.core.commom.ui.theme.White


class AboutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CacTheme {
                Scaffold(
                    topBar = {
                        AppToolbar(onBack = { finish() }, title = "Sobre")
                    },
                    /*bottomBar = {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(.8f)
                                .defaultMinSize(minHeight = 200.dp)
                                .clip(
                                    RoundedCornerShape(
                                        topStart = 30.dp,
                                        topEnd = 30.dp
                                    )
                                )
                                .background(Black50.copy(alpha = .98f)),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center

                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .background(Orange)
                            ) {
                                AppText(
                                    appTextTypes = AppTextList.BODY,
                                    text = "Termos e Sobre o Aplicativo",
                                    color = Black,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .verticalScroll(rememberScrollState())
                            )
                            {
                                AppText(
                                    appTextTypes = AppTextList.BODY,
                                    color = LightGray,
                                    text = "Este aplicativo se divide em 3 módulos:" +
                                            "\t\n1 - Módulo do Cac" +
                                            "\t\n2 - Módulo Store" +
                                            "\t\n3 - Módulo Instructor\n\n" +
                                            "Módulo do CAC:\nNeste módulo o cac, deve registrar seus dados pessoais, contatos," +
                                            "seu arsenal,certificações de cursos, e afiliação, também pode cadastrar a data de sua filiação " +
                                            "para que quando estiver perto do vencimento seja avisado, mas não se preocupe, o cac, controla quem" +
                                            "pode ver e o que poder ser visto em seu perfil, por exemplo, não quero que meu arsenal seja visto " +
                                            "em modo públicp (para outros cacs), é só ir em configurações, setar para privado e pronto, você pode" +
                                            "vender, trocar seu arsenal e muito mais..." +
                                            "\n\nMódulo Instuctor:\nNeste módulos os instrutores de tiros podem cadastrar seus dados pessoais" +
                                            "contatos, curso dos quais ministram, vídeos do youtube, arsenais e muito mais..." +
                                            "\nMódulo Store:\n" +
                                            "Este módulo é para os estandes de tiro, veja o que eles podem fazer:\n" +
                                            "Cadastrar todas as informações para os praticantes de tiros\n" +
                                            "Criar lojas, para venda de armas, artigos, acessórios, etc..\n" +
                                            "Publicar Cursos\n" +
                                            "Ter uma lista de sócios, quando o cac se cadastra ele diz a qual o clube é afiliado, assim" +
                                            "o estade de sua filiação fica sabendo que tem um socio\nCheck-In está é uma ótima" +
                                            "funcinalidade, do qual o cac faz o check in no estabelecimento, registrando assim sua presença," +
                                            "e tem muito mas muito mais\n\nO app está 100% gratuito, mas essa gratuidade se dara, pelo tempo " +
                                            "que durar a gratuidade do servidor da Google.",
                                    modifier = Modifier.padding(
                                        start = 20.dp,
                                        end = 20.dp,
                                        top = 10.dp
                                    )
                                )
                                AppDivider(
                                    Modifier.padding(20.dp)
                                )
                                AppText(
                                    appTextTypes = AppTextList.BODY,
                                    text = "Quer entrar em contato comigo?",
                                    color = White,
                                    modifier = Modifier.padding(
                                        start = 20.dp,
                                        end = 20.dp,
                                        top = 10.dp
                                    )
                                )
                                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                                    AppSpace(appSizes = AppSpaceList.LARGE)
                                    AppMidia(appICons = AppIconList.LINKEDIM) {}
                                    AppMidia(appICons = AppIconList.EMAIL) {}
                                    AppMidia(appICons = AppIconList.WHATS) {}
                                }


                                AppDivider(
                                    Modifier.padding(20.dp)
                                )
                                AppText(
                                    appTextTypes = AppTextList.BODY,
                                    text = "Termos e Responsabilidades\n\nVamos resumir para você nossos termos, você e semonte você " +
                                            "é responsavel por todo o dado que cadastra aqui, a nossa responsabilidade é de manter seus " +
                                            "dados seguros, baseado em suas configurações, todos os órgãos de segurança públicas teram acesso " +
                                            "basta solicitar, para consultas e averiguações...Use com responsabilidade, pois sempre " +
                                            "vamos colaborar com a justiça e sua legalidade. ",
                                    color = LightGray,
                                    modifier = Modifier.padding(
                                        start = 20.dp,
                                        end = 20.dp,
                                        top = 10.dp
                                    )
                                )
                                AppSpace(AppSpaceList.LARGE)
                            }
                            AppSpace(AppSpaceList.XXXLARGE)
                        }
                    }*/
                ) {

                        Card(
                            backgroundColor = Black,
                            elevation = Elevations.DEFAULT.size,
                            shape = Shapes.small,
                            modifier = Modifier
                                .padding(5.dp + it.calculateTopPadding())
                                .fillMaxSize()
                        ) {
                            Column(
                                modifier = Modifier
                                    .verticalScroll(rememberScrollState())
                                    .padding(10.dp)
                                    .fillMaxSize()

                            ) {

                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(15.dp)
                                ) {
                                    AppIcons(appIcons = AppIconList.INFO)
                                }
                                AppText(
                                    appTextTypes = AppTextList.BODY,
                                    color = LightGray,
                                    maxLines = 340,
                                    text = "Este aplicativo se divide em 3 módulos:\n" +
                                            "\t\n1 - Módulo do Cac" +
                                            "\t\n2 - Módulo Store" +
                                            "\t\n3 - Módulo Instructor\n\n" +
                                            "Módulo do CAC:\nNeste módulo o cac, deve registrar seus dados pessoais, contatos," +
                                            "seu arsenal,certificações de cursos, e afiliação, também pode cadastrar a data de sua filiação " +
                                            "para que quando estiver perto do vencimento seja avisado, mas não se preocupe, o cac, controla quem" +
                                            "pode ver e o que poder ser visto em seu perfil, por exemplo, não quero que meu arsenal seja visto " +
                                            "em modo públicp (para outros cacs), é só ir em configurações, setar para privado e pronto, você pode" +
                                            "vender, trocar seu arsenal e muito mais..." +
                                            "\n\nMódulo Instuctor:\nNeste módulos os instrutores de tiros podem cadastrar seus dados pessoais" +
                                            "contatos, curso dos quais ministram, vídeos do youtube, arsenais e muito mais..." +
                                            "\nMódulo Store:\n" +
                                            "Este módulo é para os estandes de tiro, veja o que eles podem fazer:\n" +
                                            "Cadastrar todas as informações para os praticantes de tiros\n" +
                                            "Criar lojas, para venda de armas, artigos, acessórios, etc..\n" +
                                            "Publicar Cursos\n" +
                                            "Ter uma lista de sócios, quando o cac se cadastra ele diz a qual o clube é afiliado, assim" +
                                            "o estade de sua filiação fica sabendo que tem um socio\nCheck-In está é uma ótima" +
                                            "funcinalidade, do qual o cac faz o check in no estabelecimento, registrando assim sua presença," +
                                            "e tem muito mas muito mais\n\nO app está 100% gratuito, mas essa gratuidade se dara, pelo tempo " +
                                            "que durar a gratuidade do servidor da Google.",
                                )
                                AppDivider(
                                    modifier = Modifier.padding(top= 30.dp, bottom = 30.dp),
                                    color = LightGray
                                )
                                AppText(appTextTypes = AppTextList.TITLE, text = "Contatos", color = LightGray)
                                AppSpace(appSizes = AppSpaceList.LARGE)
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    AppMidia(appICons = AppIconList.LINKEDIM) {}
                                    AppMidia(appICons = AppIconList.EMAIL) {}
                                    AppMidia(appICons = AppIconList.WHATS) {}
                                }
                                AppSpace(appSizes = AppSpaceList.LARGE)
                            }
                        }

                    }

            }
        }
    }
}
