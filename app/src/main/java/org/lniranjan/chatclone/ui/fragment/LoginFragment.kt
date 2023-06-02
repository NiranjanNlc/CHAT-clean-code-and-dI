package org.lniranjan.chatclone.ui.fragment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import org.lniranjan.chatclone.R
import org.lniranjan.chatclone.databinding.FragmentLoginBinding
import org.lniranjan.chatclone.modal.Credentials
import org.lniranjan.chatclone.ui.activity.SettingActivity
import org.lniranjan.chatclone.ui.viewmodel.AuthViewModel
import org.lniranjan.chatclone.utils.toast


@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var bindind : FragmentLoginBinding 
    val viewModel by viewModels<AuthViewModel>()
    val USERID: String = "userId"
 
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindind = DataBindingUtil.inflate(inflater,R.layout.fragment_login, container, false)
        bindind.fragment = this
        setObsever()
        return bindind.root
    }

    private fun setObsever() {
        viewModel._user.observe(viewLifecycleOwner, {
            if(it.data!= null)
            {
                navigateTonext(it.data.userName , it.data.userId)
            }
            else if(it.error != null)
            {
                requireContext().toast(it.error)
            }
        })
    }

    private fun navigateTonext(userName: String?, userId: String?) {
        if (userName != null) {
            Navigation.findNavController(bindind.root)
                .navigate(R.id.action_loginFragment_to_chatListFragment)
        }
        else
        {
            // launch main activity
            val intent = Intent(requireContext() ,SettingActivity::class.java)
            intent.putExtra(USERID, userId.toString())
            intent.putExtra("userId",userId)
            startActivity(intent)
        }
        }

    @RequiresApi(Build.VERSION_CODES.M)
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
    @RequiresApi(Build.VERSION_CODES.M)
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
        if(bindind.logInLayout.visibility==View.VISIBLE)
        {
            val email =bindind.eMail.text.toString()
            val passw =bindind.passwords.text.toString()
            Log.i(" LoginFragment", "submit: $email $passw")
            login(email, passw)
        }
        else
        {
            val emails =bindind.eMails.text.toString()
            val passw1 = bindind.passwordss.text.toString()
            val passw2 = bindind.passwords01.text.toString()
            Log.i(" LoginFragment", "submit:   $emails $passw1 $passw2")
            register(passw1, passw2, emails)
         }
    }

    private fun register(passw1: String, passw2: String, emails: String) {
        Log.i(" regisdter", "submit: $emails $emails $passw1 $passw2")
        if (passw1.equals(passw2)) {
            viewModel.register(
                Credentials(
                    mail = emails,
                    password = passw1
                )
            )
            Log.i(" regisdter", "submit: $emails $emails $passw1 $passw2")
        }
        else
            toast { "Password do not match " }
    }

    private fun login(email: String, passw: String) {
            viewModel.login(Credentials(mail = email, password = passw))
    }

  fun showNotImplementedMessage() {
        requireContext().toast("Not implemented yet")
    }
}