A utility library that does the following things:
* Check internet connection
* Validate for empty edit texts
* Validate for email
* Validate for mobile number
* Validate text for any no of digits
* Fancy Progress Dialog

[Watch it in action here](https://www.youtube.com/watch?v=GYuSOIA-toA)


# How to add
Add this in the project level build.gradle:

                 repositories{
                      ....
                      maven { url 'https://jitpack.io' }
                 }
And this in the app level build.gradle  

    compile 'com.github.shree-vastava:ValidUtil:v1.0'

# How to use
Create an object of the ValidUtils class

        ValidUtils validUtils = new ValidUtils() 

### Check for internet connection
        if (validUtils.isNetworkAvailable(this)){
            // do whatever you want to do IF internet is AVAILABLE
        }

### Check for empty EditTexts
        if(validUtils.validateEditTexts(name,mobile,email)){ //where name,mobile, email are EditTexts
            // do whatever you want to do if EditTexts are not empty
        }

### Check for Email validation
        if(validUtils.validateEmail(email)){
             // do whatever you want to do if email is valid i.e in form of something@somedomain.someextension
        }
You can check for more email EditTexts also by passing comma separate EditTexts in the above function

### Check for mobile Number
        if(validUtils.validateMobileNumber(mobile)){
             // do whatever you want to do if mobile number is valid i.e 10 digits
        }
You can check for multiple mobile EditTexts

### Check for no of digits in an EditText
        if(validUtils.validateForDigits(Pin,6)){
             // do whatever you want to do if Pin is 6 digits
        }
Here Pin the EditText

### Show and hide Fancy Progress Dialog

       validUtils.showProgresDialog(this,this)
where the arguements are like

       validUtils.showProgressDialog(Context, Activity)

To hide the dialog

       validUtils.hideProgressDialog()

### The last and simplest as well as bonus functionality
### The Toast

      validUtils.showToast(Context,"some message")
