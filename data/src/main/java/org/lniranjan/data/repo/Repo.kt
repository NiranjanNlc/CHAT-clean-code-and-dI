package org.lniranjan.data.repo

import org.lniranjan.data.source.DataSource

class Repo(
    private val dataSource: DataSource
) {
     fun save()= dataSource.save()
}