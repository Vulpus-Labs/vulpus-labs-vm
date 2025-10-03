package com.vulpuslabs.swirlmini;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
import com.vulpuslabs.vulpes.modules.swirl.*;


//[/user-imports]


public class SwirlMini extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

   public SwirlMini( long moduleID, VoltageObjects voltageObjects )
   {
      super( moduleID, voltageObjects, "Swirl Mini", ModuleType.ModuleType_PolyphonicUtilities, 1.4 );

      InitializeControls();


      canBeBypassed = false;
      SetSkin( "a2c8e5513e624cff8be0adb881a7294a" );
   }

void InitializeControls()
{

      polyOutputX = new VoltagePolyJack( "polyOutputX", "Poly Output X", this, JackType.JackType_PolyOutput );
      AddComponent( polyOutputX );
      polyOutputX.SetWantsMouseNotifications( false );
      polyOutputX.SetPosition( 14, 315 );
      polyOutputX.SetSize( 25, 25 );
      polyOutputX.SetSkin( "Poly Jack Straight" );

      polyOutputY = new VoltagePolyJack( "polyOutputY", "Poly Output Y", this, JackType.JackType_PolyOutput );
      AddComponent( polyOutputY );
      polyOutputY.SetWantsMouseNotifications( false );
      polyOutputY.SetPosition( 60, 315 );
      polyOutputY.SetSize( 25, 25 );
      polyOutputY.SetSkin( "Poly Jack Straight" );

      interpolationLengthKnob = new VoltageKnob( "interpolationLengthKnob", "Drift Length", this, 0, 1, 0.2 );
      AddComponent( interpolationLengthKnob );
      interpolationLengthKnob.SetWantsMouseNotifications( false );
      interpolationLengthKnob.SetPosition( 45, 131 );
      interpolationLengthKnob.SetSize( 25, 25 );
      interpolationLengthKnob.SetSkin( "ARP2500 Sm Aqua" );
      interpolationLengthKnob.SetRange( 0, 1, 0.2, false, 0 );
      interpolationLengthKnob.SetKnobParams( 215, 145 );
      interpolationLengthKnob.DisplayValueInPercent( false );
      interpolationLengthKnob.SetKnobAdjustsRing( true );

      interpolationLengthRange = new VoltageSwitch( "interpolationLengthRange", "Interpolation Length Range", this, 1 );
      AddComponent( interpolationLengthRange );
      interpolationLengthRange.SetWantsMouseNotifications( false );
      interpolationLengthRange.SetPosition( 65, 129 );
      interpolationLengthRange.SetSize( 30, 30 );
      interpolationLengthRange.SetSkin( "3-State Silver" );

      textLabel1 = new VoltageLabel( "textLabel1", "textLabel1", this, "VULPUS LABS" );
      AddComponent( textLabel1 );
      textLabel1.SetWantsMouseNotifications( false );
      textLabel1.SetPosition( 0, 341 );
      textLabel1.SetSize( 100, 19 );
      textLabel1.SetEditable( false, false );
      textLabel1.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel1.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel1.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel1.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel1.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel1.SetBorderSize( 1 );
      textLabel1.SetMultiLineEdit( false );
      textLabel1.SetIsNumberEditor( false );
      textLabel1.SetNumberEditorRange( 0, 100 );
      textLabel1.SetNumberEditorInterval( 1 );
      textLabel1.SetNumberEditorUsesMouseWheel( false );
      textLabel1.SetHasCustomTextHoverColor( false );
      textLabel1.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel1.SetFont( "Arial", 10, true, false );

      textLabel2 = new VoltageLabel( "textLabel2", "textLabel2", this, "SWIRL MINI" );
      AddComponent( textLabel2 );
      textLabel2.SetWantsMouseNotifications( false );
      textLabel2.SetPosition( 0, 0 );
      textLabel2.SetSize( 100, 19 );
      textLabel2.SetEditable( false, false );
      textLabel2.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel2.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel2.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel2.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel2.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel2.SetBorderSize( 1 );
      textLabel2.SetMultiLineEdit( false );
      textLabel2.SetIsNumberEditor( false );
      textLabel2.SetNumberEditorRange( 0, 100 );
      textLabel2.SetNumberEditorInterval( 1 );
      textLabel2.SetNumberEditorUsesMouseWheel( false );
      textLabel2.SetHasCustomTextHoverColor( false );
      textLabel2.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel2.SetFont( "Arial", 10, true, false );

      angleInput = new VoltagePolyJack( "angleInput", "Poly Angle Input", this, JackType.JackType_PolyInput );
      AddComponent( angleInput );
      angleInput.SetWantsMouseNotifications( false );
      angleInput.SetPosition( 9, 98 );
      angleInput.SetSize( 25, 25 );
      angleInput.SetSkin( "Poly Jack Straight" );

      thetaDriveKnob = new VoltageKnob( "thetaDriveKnob", "Theta Drive", this, 0, 5, 2.50 );
      AddComponent( thetaDriveKnob );
      thetaDriveKnob.SetWantsMouseNotifications( false );
      thetaDriveKnob.SetPosition( 9, 140 );
      thetaDriveKnob.SetSize( 25, 25 );
      thetaDriveKnob.SetSkin( "ARP2500 Sm Aqua" );
      thetaDriveKnob.SetRange( 0, 5, 2.50, false, 0 );
      thetaDriveKnob.SetKnobParams( 215, 145 );
      thetaDriveKnob.DisplayValueInPercent( true );
      thetaDriveKnob.SetKnobAdjustsRing( true );

      thetaDriveModInput = new VoltageAudioJack( "thetaDriveModInput", "Theta Drive Modulation", this, JackType.JackType_AudioInput );
      AddComponent( thetaDriveModInput );
      thetaDriveModInput.SetWantsMouseNotifications( false );
      thetaDriveModInput.SetPosition( 9, 204 );
      thetaDriveModInput.SetSize( 25, 25 );
      thetaDriveModInput.SetSkin( "Jack Round Green Ring" );

      triggerDriftInput = new VoltageAudioJack( "triggerDriftInput", "Trigger Drift Input", this, JackType.JackType_AudioInput );
      AddComponent( triggerDriftInput );
      triggerDriftInput.SetWantsMouseNotifications( false );
      triggerDriftInput.SetPosition( 54, 75 );
      triggerDriftInput.SetSize( 25, 25 );
      triggerDriftInput.SetSkin( "Jack Round Green Ring" );

      textLabel3 = new VoltageLabel( "textLabel3", "textLabel3", this, "θ in" );
      AddComponent( textLabel3 );
      textLabel3.SetWantsMouseNotifications( false );
      textLabel3.SetPosition( 6, 122 );
      textLabel3.SetSize( 31, 19 );
      textLabel3.SetEditable( false, false );
      textLabel3.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel3.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel3.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel3.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel3.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel3.SetBorderSize( 1 );
      textLabel3.SetMultiLineEdit( false );
      textLabel3.SetIsNumberEditor( false );
      textLabel3.SetNumberEditorRange( 0, 100 );
      textLabel3.SetNumberEditorInterval( 1 );
      textLabel3.SetNumberEditorUsesMouseWheel( false );
      textLabel3.SetHasCustomTextHoverColor( false );
      textLabel3.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel3.SetFont( "Arial", 12, true, false );

      textLabel4 = new VoltageLabel( "textLabel4", "textLabel4", this, "r in" );
      AddComponent( textLabel4 );
      textLabel4.SetWantsMouseNotifications( false );
      textLabel4.SetPosition( 11, 40 );
      textLabel4.SetSize( 24, 19 );
      textLabel4.SetEditable( false, false );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel4.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel4.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel4.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel4.SetBorderSize( 1 );
      textLabel4.SetMultiLineEdit( false );
      textLabel4.SetIsNumberEditor( false );
      textLabel4.SetNumberEditorRange( 0, 100 );
      textLabel4.SetNumberEditorInterval( 1 );
      textLabel4.SetNumberEditorUsesMouseWheel( false );
      textLabel4.SetHasCustomTextHoverColor( false );
      textLabel4.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel4.SetFont( "Arial", 12, true, false );

      radiusInput = new VoltagePolyJack( "radiusInput", "Poly Radius Input", this, JackType.JackType_PolyInput );
      AddComponent( radiusInput );
      radiusInput.SetWantsMouseNotifications( false );
      radiusInput.SetPosition( 10, 58 );
      radiusInput.SetSize( 25, 25 );
      radiusInput.SetSkin( "Poly Jack Straight" );

      textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "START DRIFT" );
      AddComponent( textLabel5 );
      textLabel5.SetWantsMouseNotifications( false );
      textLabel5.SetPosition( 42, 51 );
      textLabel5.SetSize( 50, 20 );
      textLabel5.SetEditable( false, false );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel5.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel5.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel5.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel5.SetBorderSize( 1 );
      textLabel5.SetMultiLineEdit( true );
      textLabel5.SetIsNumberEditor( false );
      textLabel5.SetNumberEditorRange( 0, 100 );
      textLabel5.SetNumberEditorInterval( 1 );
      textLabel5.SetNumberEditorUsesMouseWheel( false );
      textLabel5.SetHasCustomTextHoverColor( false );
      textLabel5.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel5.SetFont( "Arial", 10, true, false );

      startDriftButton = new VoltageButton( "startDriftButton", "Start Drift", this );
      AddComponent( startDriftButton );
      startDriftButton.SetWantsMouseNotifications( false );
      startDriftButton.SetPosition( 57, 25 );
      startDriftButton.SetSize( 21, 21 );
      startDriftButton.SetSkin( "Mini Gray-Green" );
      startDriftButton.ShowOverlay( false );
      startDriftButton.SetOverlayText( "" );
      startDriftButton.SetAutoRepeat( false );

      autoRetrigToggle = new VoltageToggle( "autoRetrigToggle", "Drift Auto Retrigger", this, true, 0 );
      AddComponent( autoRetrigToggle );
      autoRetrigToggle.SetWantsMouseNotifications( false );
      autoRetrigToggle.SetPosition( 57, 185 );
      autoRetrigToggle.SetSize( 21, 21 );
      autoRetrigToggle.SetSkin( "Mini Blue" );
      autoRetrigToggle.ShowOverlay( false );
      autoRetrigToggle.SetOverlayText( "" );

      textLabel10 = new VoltageLabel( "textLabel10", "textLabel10", this, "TRIGGER DRIFT" );
      AddComponent( textLabel10 );
      textLabel10.SetWantsMouseNotifications( false );
      textLabel10.SetPosition( 42, 104 );
      textLabel10.SetSize( 50, 20 );
      textLabel10.SetEditable( false, false );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel10.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel10.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel10.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel10.SetBorderSize( 1 );
      textLabel10.SetMultiLineEdit( true );
      textLabel10.SetIsNumberEditor( false );
      textLabel10.SetNumberEditorRange( 0, 100 );
      textLabel10.SetNumberEditorInterval( 1 );
      textLabel10.SetNumberEditorUsesMouseWheel( false );
      textLabel10.SetHasCustomTextHoverColor( false );
      textLabel10.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel10.SetFont( "Arial", 10, true, false );

      textLabel11 = new VoltageLabel( "textLabel11", "textLabel11", this, "DRIFT LENGTH" );
      AddComponent( textLabel11 );
      textLabel11.SetWantsMouseNotifications( false );
      textLabel11.SetPosition( 42, 160 );
      textLabel11.SetSize( 50, 20 );
      textLabel11.SetEditable( false, false );
      textLabel11.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel11.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel11.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel11.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel11.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel11.SetBorderSize( 1 );
      textLabel11.SetMultiLineEdit( true );
      textLabel11.SetIsNumberEditor( false );
      textLabel11.SetNumberEditorRange( 0, 100 );
      textLabel11.SetNumberEditorInterval( 1 );
      textLabel11.SetNumberEditorUsesMouseWheel( false );
      textLabel11.SetHasCustomTextHoverColor( false );
      textLabel11.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel11.SetFont( "Arial", 10, true, false );

      textLabel12 = new VoltageLabel( "textLabel12", "textLabel12", this, "AUTO RETRIG" );
      AddComponent( textLabel12 );
      textLabel12.SetWantsMouseNotifications( false );
      textLabel12.SetPosition( 42, 210 );
      textLabel12.SetSize( 50, 20 );
      textLabel12.SetEditable( false, false );
      textLabel12.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel12.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel12.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel12.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel12.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel12.SetBorderSize( 1 );
      textLabel12.SetMultiLineEdit( true );
      textLabel12.SetIsNumberEditor( false );
      textLabel12.SetNumberEditorRange( 0, 100 );
      textLabel12.SetNumberEditorInterval( 1 );
      textLabel12.SetNumberEditorUsesMouseWheel( false );
      textLabel12.SetHasCustomTextHoverColor( false );
      textLabel12.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel12.SetFont( "Arial", 10, true, false );

      textLabel13 = new VoltageLabel( "textLabel13", "textLabel13", this, "DESYNC" );
      AddComponent( textLabel13 );
      textLabel13.SetWantsMouseNotifications( false );
      textLabel13.SetPosition( 42, 254 );
      textLabel13.SetSize( 50, 20 );
      textLabel13.SetEditable( false, false );
      textLabel13.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel13.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel13.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel13.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel13.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel13.SetBorderSize( 1 );
      textLabel13.SetMultiLineEdit( true );
      textLabel13.SetIsNumberEditor( false );
      textLabel13.SetNumberEditorRange( 0, 100 );
      textLabel13.SetNumberEditorInterval( 1 );
      textLabel13.SetNumberEditorUsesMouseWheel( false );
      textLabel13.SetHasCustomTextHoverColor( false );
      textLabel13.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel13.SetFont( "Arial", 10, true, false );

      driftLengthDesyncToggle = new VoltageToggle( "driftLengthDesyncToggle", "Drift Length Desync", this, true, 0 );
      AddComponent( driftLengthDesyncToggle );
      driftLengthDesyncToggle.SetWantsMouseNotifications( false );
      driftLengthDesyncToggle.SetPosition( 56, 234 );
      driftLengthDesyncToggle.SetSize( 21, 21 );
      driftLengthDesyncToggle.SetSkin( "Mini Blue" );
      driftLengthDesyncToggle.ShowOverlay( false );
      driftLengthDesyncToggle.SetOverlayText( "" );

      textLabel14 = new VoltageLabel( "textLabel14", "textLabel14", this, "X" );
      AddComponent( textLabel14 );
      textLabel14.SetWantsMouseNotifications( false );
      textLabel14.SetPosition( 4, 297 );
      textLabel14.SetSize( 45, 20 );
      textLabel14.SetEditable( false, false );
      textLabel14.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel14.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel14.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel14.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel14.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel14.SetBorderSize( 1 );
      textLabel14.SetMultiLineEdit( true );
      textLabel14.SetIsNumberEditor( false );
      textLabel14.SetNumberEditorRange( 0, 100 );
      textLabel14.SetNumberEditorInterval( 1 );
      textLabel14.SetNumberEditorUsesMouseWheel( false );
      textLabel14.SetHasCustomTextHoverColor( false );
      textLabel14.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel14.SetFont( "Arial", 10, true, false );

      textLabel15 = new VoltageLabel( "textLabel15", "textLabel15", this, "Y" );
      AddComponent( textLabel15 );
      textLabel15.SetWantsMouseNotifications( false );
      textLabel15.SetPosition( 50, 297 );
      textLabel15.SetSize( 45, 20 );
      textLabel15.SetEditable( false, false );
      textLabel15.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel15.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel15.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel15.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel15.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel15.SetBorderSize( 1 );
      textLabel15.SetMultiLineEdit( true );
      textLabel15.SetIsNumberEditor( false );
      textLabel15.SetNumberEditorRange( 0, 100 );
      textLabel15.SetNumberEditorInterval( 1 );
      textLabel15.SetNumberEditorUsesMouseWheel( false );
      textLabel15.SetHasCustomTextHoverColor( false );
      textLabel15.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel15.SetFont( "Arial", 10, true, false );

      thetaDriveModAmountKnob = new VoltageKnob( "thetaDriveModAmountKnob", "Theta Drive Modulation Amount", this, -1, 1, 0 );
      AddComponent( thetaDriveModAmountKnob );
      thetaDriveModAmountKnob.SetWantsMouseNotifications( false );
      thetaDriveModAmountKnob.SetPosition( 12, 180 );
      thetaDriveModAmountKnob.SetSize( 19, 19 );
      thetaDriveModAmountKnob.SetSkin( "ARP2500 Sm Gold" );
      thetaDriveModAmountKnob.SetRange( -1, 1, 0, false, 0 );
      thetaDriveModAmountKnob.SetKnobParams( 215, 145 );
      thetaDriveModAmountKnob.DisplayValueInPercent( true );
      thetaDriveModAmountKnob.SetKnobAdjustsRing( false );

      radiusBipolarSwitch = new VoltageSwitch( "radiusBipolarSwitch", "Radius Bipolar", this, 0 );
      AddComponent( radiusBipolarSwitch );
      radiusBipolarSwitch.SetWantsMouseNotifications( false );
      radiusBipolarSwitch.SetPosition( 10, 25 );
      radiusBipolarSwitch.SetSize( 25, 13 );
      radiusBipolarSwitch.SetSkin( "2-State Slide Horizontal" );

      dcCorrectionSwitch = new VoltageSwitch( "dcCorrectionSwitch", "DC Correction", this, 0 );
      AddComponent( dcCorrectionSwitch );
      dcCorrectionSwitch.SetWantsMouseNotifications( false );
      dcCorrectionSwitch.SetPosition( 44, 304 );
      dcCorrectionSwitch.SetSize( 12, 21 );
      dcCorrectionSwitch.SetSkin( "2-State Slide Vertical" );

      textLabel6 = new VoltageLabel( "textLabel6", "textLabel6", this, "DRIVE" );
      AddComponent( textLabel6 );
      textLabel6.SetWantsMouseNotifications( false );
      textLabel6.SetPosition( 6, 163 );
      textLabel6.SetSize( 31, 20 );
      textLabel6.SetEditable( false, false );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel6.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel6.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel6.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel6.SetBorderSize( 1 );
      textLabel6.SetMultiLineEdit( true );
      textLabel6.SetIsNumberEditor( false );
      textLabel6.SetNumberEditorRange( 0, 100 );
      textLabel6.SetNumberEditorInterval( 1 );
      textLabel6.SetNumberEditorUsesMouseWheel( false );
      textLabel6.SetHasCustomTextHoverColor( false );
      textLabel6.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel6.SetFont( "Arial", 8, true, false );
}



   //-------------------------------------------------------------------------------
   //  public void Initialize()

      //  Initialize will get called shortly after your module's constructor runs. You can use it to
      //  do any initialization that the auto-generated code doesn't handle.
   //-------------------------------------------------------------------------------
   @Override
   public void Initialize()
   {
      //[user-Initialize]   Add your own initialization code here
      
      var maxSize = GetMaxNumberOfPolyVoices();
      var activeSize = GetNumberOfPolyVoices();
      var model = new SwirlModel(maxSize);
      
      SwirlView view = new NoOpSwirlView();
      
      SwirlInputs swirlInputs = new SwirlInputs(
         Values::FastRandomInclusive,
         thetaDriveModInput::GetValue,
         triggerDriftInput::GetValue,
         maxSize,
         activeSize);
      swirlInputs.connectAngles((channel) -> () -> angleInput.GetPolyValue(channel));
      swirlInputs.connectRadii((channel) -> () -> radiusInput.GetPolyValue(channel));
      
      SwirlOutputs swirlOutputs = new SwirlOutputs(
         maxSize,
         activeSize,
         (channel) -> (value) -> polyOutputX.SetPolyValue(channel, value),
         (channel) -> (value) -> polyOutputY.SetPolyValue(channel, value));
      
      InterpolationController interpolationController = new InterpolationController(Values::FastRandomInclusive);
      
      controller = new SwirlController(
         model,
         view,
         swirlInputs,
         swirlOutputs,
         interpolationController);
      
      controller.initialise();
      
      dcCorrectionSwitch.SetEnabled(false);
      //[/user-Initialize]
   }


   //-------------------------------------------------------------------------------
   //  public void Destroy()

      //  Destroy will get called just before your module gets deleted. You can use it to perform any
      //  cleanup that's not handled automatically by Java.
   //-------------------------------------------------------------------------------
   @Override
   public void Destroy()
   {
      super.Destroy();
      //[user-Destroy]   Add your own module-getting-deleted code here



      //[/user-Destroy]
   }


   //-------------------------------------------------------------------------------
   //  public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )

      //  Notify will get called when various events occur - control values changing, timers firing, etc.
   //-------------------------------------------------------------------------------
   @Override
   public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )
   {
      //[user-Notify]   Add your own notification handling code between this line and the notify-close comment
      switch( notification )
      {
         case Knob_Changed:   // doubleValue is the new VoltageKnob value
         {
            if (component == interpolationLengthKnob) {
               controller.setInterpolationLength(doubleValue);
            }
            if (component == thetaDriveModAmountKnob) {
               controller.setDriveMod(doubleValue);
            }
            if (component == thetaDriveKnob) {
               controller.setDrive(doubleValue);
            }
         }
         break;
      
         case Slider_Changed:   // doubleValue is the new slider value
         {
         }
         break;
      
         case Button_Changed:   // doubleValue is the new button/toggle button value
         {
            if (component == driftLengthDesyncToggle) {
               controller.setDesync(doubleValue == 1.0);
            }
            if (component == autoRetrigToggle) {
               controller.setAutoRetrig(doubleValue == 1.0);
            }
            if (component == startDriftButton && doubleValue == 1.0) {
               controller.setNewTargets();
            }
         }
         break;
      
         case Switch_Changed:   // doubleValue is the new switch value
         {
            if (component == interpolationLengthRange) {
               controller.setInterpolationRange((int) doubleValue, interpolationLengthKnob.GetValue());
            }
            if (component == radiusBipolarSwitch) {
               controller.setRadiusBipolar(doubleValue == 1.0);
            }
            if (component == dcCorrectionSwitch) {
               controller.setBlockingDc(doubleValue == 1.0);
            }
         }
         break;
      
         case Jack_Connected:   // longValue is the new cable ID
         {
            if (component == angleInput || component == radiusInput) {
               controller.startProcessingAudio();
               dcCorrectionSwitch.SetEnabled(true);
               controller.setBlockingDc(doubleValue == 1.0);
            }
            if (component == thetaDriveModInput) {
               controller.connectDriveMod();
            }
            if (component == triggerDriftInput) {
               controller.connectTriggerDriftInput();
            }
         }
         break;
      
         case Jack_Disconnected:   // All cables have been disconnected from this jack
         {
            if (component == angleInput || component == radiusInput) {
               if (!angleInput.IsConnected() && !radiusInput.IsConnected()) {
                  controller.stopProcessingAudio();
                  dcCorrectionSwitch.SetEnabled(false);
               controller.setBlockingDc(false);
               }
            }
            if (component == thetaDriveModInput) {
               controller.disconnectDriveMod();
            }
            if (component == triggerDriftInput) {
               controller.disconnectTriggerDriftInput();
            }
         }
         break;
      
         case GUI_Update_Timer:   // Called every 50ms (by default) if turned on
         {
         }
         break;
      
         case Object_MouseMove:   // called when mouse is over an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_MouseLeave:  // called when mouse leaves an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_LeftButtonDown:   // called when user left-clicks on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_LeftButtonUp:   // called when user releases left mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_RightButtonDown:   // called when user releases right mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_RightButtonUp:   // called when user right-clicks on an object that receives mouse notifications
         {
         }
         break;
      
         case Object_LeftButtonDoubleClick: // called when user left-button double-clicks on an object that receives mouse notifications
         {
         }
         break;
      
         // Less common notifications:
      
         case Named_Timer:   // object contains a String with the name of the timer that has fired
         {
         }
         break;
      
         case Canvas_Painting:   // About to paint canvas.  object is a java.awt.Rectangle with painting boundaries
         {
         }
         break;
      
         case Canvas_Painted:   // Canvas painting is complete
         {
         }
         break;
      
         case Control_DragStart:    // A user has started dragging on a control that has been marked as draggable
         {
         }
         break;
      
         case Control_DragOn:       // This control has been dragged over during a drag operation. object contains the dragged object
         {
         }
         break;
      
         case Control_DragOff:      // This control has been dragged over during a drag operation. object contains the dragged object
         {
         }
         break;
      
         case Control_DragEnd:      // A user has ended their drag on a control that has been marked as draggable
         {
         }
         break;
      
         case Label_Changed:        // The text of an editable text control has changed
         {
         }
         break;
      
         case SoundPlayback_Start:   // A sound has begun playback
         {
         }
         break;
      
         case SoundPlayback_End:     // A sound has ended playback
         {
         }
         break;
      
         case Scrollbar_Position:    // longValue is the new scrollbar position
         {
         }
         break;
      
         case PolyVoices_Changed:    // longValue is the new number of poly voices
         {
            controller.setActiveSize((int) longValue);
         }
         break;
      
         case File_Dropped:     // 'object' is a String containing the file path
         {
         }
         break;
      
         case Preset_Loading_Start:   // called when preset loading begins
         {
         }
         break;
      
         case Preset_Loading_Finish:  // called when preset loading finishes
         {
         }
         break;
      
         case Variation_Loading_Start:    // sent when a variation is about to load
         {
         }
         break;
      
         case Variation_Loading_Finish:   // sent when a variation has just finished loading
         {
         }
         break;
      
         case Tempo_Changed:     // doubleValue is the new tempo
         {
         }
         break;
      
         case Randomized:     // called when the module's controls get randomized
         {
         }
         break;
      
         case VariationListChanged:   // sent when a variation gets added, deleted, or renamed, or the variations list gets reordered
         {
         }
         break;
      
         case Key_Press:     // sent when module has keyboard focus and a key is pressed; object is a VoltageKeyPressInfo object
         {
         }
         break;
      
         case Reset:    // sent when the module has been reset to default settings
         {
         }
         break;
      
         case Keyboard_NoteOn:   // sent when a note has been pressed on a VoltageKeyboard object. longValue is the note value ( 0-127 )
         {
         }
         break;
      
         case Keyboard_NoteOff:   // sent when a note has been released on a VoltageKeyboard object. longValue is the note value ( 0-127 )
         {
         }
         break;
      
         case Curve_Changed:   // sent when user has edited a curve's value. 'object' will be a VoltageCurve.CurveChangeNotification object.
         {
         }
         break;
      }



      return false;
      //[/user-Notify]
   }


   //-------------------------------------------------------------------------------
   //  public void ProcessSample()

      //  ProcessSample is called once per sample. Usually it's where you read
      //  from input jacks, process audio, and write it to your output jacks.
      //  Since ProcesssSample gets called 48,000 times per second, offload CPU-intensive operations
      //  to other threads when possible and avoid calling native functions.
   //-------------------------------------------------------------------------------
   @Override
   public void ProcessSample()
   {
      //[user-ProcessSample]   Add your own process-sampling code here
      controller.tick();
      //[/user-ProcessSample]
   }


   //-------------------------------------------------------------------------------
   //  public String GetTooltipText( VoltageComponent component )

      //  Gets called when a tooltip is about to display for a control. Override it if
      //  you want to change what the tooltip displays - if you want a knob to work in logarithmic fashion,
      //  for instance, you can translate the knob's current value to a log-based string and display it here.
   //-------------------------------------------------------------------------------
   @Override
   public String GetTooltipText( VoltageComponent component )
   {
      //[user-GetTooltipText]   Add your own code here
      if (component == interpolationLengthKnob) {
         return controller.describeInterpolationLength(interpolationLengthKnob.GetValue());
      }
      if (component == interpolationLengthRange) {
         return controller.describeInterpolationRange();
      }
      if (component == radiusBipolarSwitch) {
         return "Radius " + ((radiusBipolarSwitch.GetValue() == 1.0)
            ? "Bipolar"
            : "Unipolar");
      }
      if (component == dcCorrectionSwitch) {
         return "DC Correction " + ((dcCorrectionSwitch.GetValue() == 1.0)
            ? "On"
            : "Off");
      }


      return super.GetTooltipText( component );
      //[/user-GetTooltipText]
   }


   //-------------------------------------------------------------------------------
   //  public void EditComponentValue( VoltageComponent component, double newValue, String newText )

      //  Gets called after a user clicks on a tooltip and types in a new value for a control. Override this if
      //  you've changed the default tooltip display (translating a linear value to logarithmic, for instance)
      //  in GetTooltipText().
   //-------------------------------------------------------------------------------
   @Override
   public void EditComponentValue( VoltageComponent component, double newValue, String newText )
   {
      //[user-EditComponentValue]   Add your own code here



      //[/user-EditComponentValue]
      super.EditComponentValue( component, newValue, newText );
   }


   //-------------------------------------------------------------------------------
   //  public void OnUndoRedo( String undoType, double newValue, Object optionalObject )

      //  If you've created custom undo events via calls to CreateUndoEvent, you'll need to
      //  process them in this function when they get triggered by undo/redo actions.
   //-------------------------------------------------------------------------------
   @Override
   public void OnUndoRedo( String undoType, double newValue, Object optionalObject )
   {
      //[user-OnUndoRedo]   Add your own code here



      //[/user-OnUndoRedo]
   }


   //-------------------------------------------------------------------------------
   //  public byte[] GetStateInformation()

      //  Gets called when the module's state gets saved, typically when the user saves a preset with
      //  this module in it. Voltage Modular will automatically save the states of knobs, sliders, etc.,
      //  but if you have any custom state information you need to save, return it from this function.
   //-------------------------------------------------------------------------------
   @Override
   public byte[] GetStateInformation()
   {
      //[user-GetStateInformation]   Add your own code here



      return null;
      //[/user-GetStateInformation]
   }


   //-------------------------------------------------------------------------------
   //  public void SetStateInformation(byte[] stateInfo)

      //  Gets called when this module's state is getting restored, typically when a user opens a preset with
      //  this module in it. The stateInfo parameter will contain whatever custom data you stored in GetStateInformation().
   //-------------------------------------------------------------------------------
   @Override
   public void SetStateInformation(byte[] stateInfo)
   {
      //[user-SetStateInformation]   Add your own code here



      //[/user-SetStateInformation]
   }


   //-------------------------------------------------------------------------------
   //  public byte[] GetStateInformationForVariations()

      //  Gets called when a user saves a variation with this module in it.
      //  Voltage Modular will automatically save the states of knobs, sliders, etc.,
      //  but if you have any custom state information you need to save, return it from this function.
   //-------------------------------------------------------------------------------
   @Override
   public byte[] GetStateInformationForVariations()
   {
      //[user-GetStateInformationForVariations]   Add your own code here



      return GetStateInformation();
      //[/user-GetStateInformationForVariations]
   }


   //-------------------------------------------------------------------------------
   //  public void SetStateInformationForVariations(byte[] stateInfo)

      //  Gets called when a user loads a variation with this module in it.
      //  The stateInfo parameter will contain whatever custom data you stored in GetStateInformationForVariations().
   //-------------------------------------------------------------------------------
   @Override
   public void SetStateInformationForVariations(byte[] stateInfo)
   {
      //[user-SetStateInformationForVariations]   Add your own code here
      SetStateInformation(stateInfo);



      //[/user-SetStateInformationForVariations]
   }


   // Auto-generated variables
   private VoltageLabel textLabel6;
   private VoltageSwitch dcCorrectionSwitch;
   private VoltageSwitch radiusBipolarSwitch;
   private VoltageKnob thetaDriveModAmountKnob;
   private VoltageLabel textLabel15;
   private VoltageLabel textLabel14;
   private VoltageToggle driftLengthDesyncToggle;
   private VoltageLabel textLabel13;
   private VoltageLabel textLabel12;
   private VoltageLabel textLabel11;
   private VoltageLabel textLabel10;
   private VoltageToggle autoRetrigToggle;
   private VoltageButton startDriftButton;
   private VoltageLabel textLabel5;
   private VoltagePolyJack radiusInput;
   private VoltageLabel textLabel4;
   private VoltageLabel textLabel3;
   private VoltageAudioJack triggerDriftInput;
   private VoltageAudioJack thetaDriveModInput;
   private VoltageKnob thetaDriveKnob;
   private VoltagePolyJack angleInput;
   private VoltageLabel textLabel2;
   private VoltageLabel textLabel1;
   private VoltageSwitch interpolationLengthRange;
   private VoltageKnob interpolationLengthKnob;
   private VoltagePolyJack polyOutputY;
   private VoltagePolyJack polyOutputX;


   //[user-code-and-variables]    Add your own variables and functions here

private SwirlController controller;

   //[/user-code-and-variables]
}

 