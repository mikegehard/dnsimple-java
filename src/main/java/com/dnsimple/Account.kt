package com.dnsimple

import com.google.api.client.util.Key


class Account (@Key("id") val id: Int = 0, @Key("email") val email: String = "")
