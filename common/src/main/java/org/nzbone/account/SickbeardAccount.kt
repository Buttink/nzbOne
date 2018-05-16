package org.nzbone.account

data class SickbeardAccount(val id: Int,
                            val url: String,
                            val username: String,
                            val password: String,
                            val apiKey: String)
