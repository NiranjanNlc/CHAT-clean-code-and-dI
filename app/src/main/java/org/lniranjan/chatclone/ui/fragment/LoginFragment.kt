package org.lniranjan.chatclone.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import org.lniranjan.chatclone.R
import org.lniranjan.chatclone.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var bindind : FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindind = DataBindingUtil.inflate(inflater,R.layout.fragment_login, container, false)
        bindind.fragment = this
        return bindind.root
    }

    public fun enableLogin() {

        bindind.logIn.apply {
            background =resources.getDrawable(R.drawable.switch_trcks, null)
            setTextColor(resources.getColor(R.color.textColor, null))
        }
        bindind.signUp.apply {
            background =null
            setTextColor(resources.getColor(R.color.pinkColor, null))
        }
        bindind.logInLayout.visibility = View.VISIBLE
        bindind.signUpLayout.visibility= View.GONE
    }
    public fun enableSignUp() {
        bindind.signUp.apply {
            background =resources.getDrawable(R.drawable.switch_trcks, null)
            setTextColor(resources.getColor(R.color.textColor, null))
        }
        bindind.logIn.apply {
            background =null
            setTextColor(resources.getColor(R.color.pinkColor, null))
        }
        bindind.signUpLayout.visibility = View.VISIBLE
        bindind.logInLayout.visibility= View.GONE
    }
 }