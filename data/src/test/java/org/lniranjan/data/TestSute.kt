package org.lniranjan.data

import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.lniranjan.data.repo.AuthenticationImplTest
import org.lniranjan.data.source.firebase.FirebaseAuthenciation
import org.lniranjan.data.source.firebase.FirebaseAuthenciationTest


@RunWith(Suite::class)
@Suite.SuiteClasses(FirebaseAuthenciationTest::class, AuthenticationImplTest::class)
class TestSute {

}