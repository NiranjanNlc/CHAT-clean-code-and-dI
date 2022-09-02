package org.lniranjan.chatclone.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup 
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import org.lniranjan.chatclone.R
import org.lniranjan.chatclone.databinding.FragmentLoginBinding
import org.lniranjan.chatclone.ui.viewmodel.AuthViewModel
import org.lniranjan.chatclone.utils.toast
import org.lniranjan.domain.entity.User
 


class LoginFragment : Fragment() {

    private lateinit var bindind : FragmentLoginBinding 
    private val viewModel by viewModels<AuthViewModel>()
 
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
    public fun submit ()
    {
        val email =bindind.eMail.text.toString()
        val passw =bindind.passwords.text.toString()
        val emails =bindind.eMails.text.toString()
        val passw1 = bindind.passwordss.text.toString()
        val passw2 = bindind.passwords01.text.toString()
        if(bindind.logInLayout.visibility==View.VISIBLE)
        {
            viewModel.login(User(mail = email, password = passw))
        }
        else
        {
          if(passw1.equals(passw2))
              viewModel.register(User(mail = emails, password = passw1))
            else
                toast { "Password do not match " }
         }
    } 
 }