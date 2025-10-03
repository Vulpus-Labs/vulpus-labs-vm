package com.vulpuslabs.crossfadegrid;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
//[/user-imports]


public class CrossFadeGrid extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

public CrossFadeGrid( long moduleID, VoltageObjects voltageObjects )
{
   super( moduleID, voltageObjects, "Cross Fade Grid", ModuleType.ModuleType_Sequencers, 4.0 );

   InitializeControls();


   canBeBypassed = false;
   SetSkin( "77b3f0d8cf9844efa2fbdf5322fd6c5e" );
}

void InitializeControls()
{

   textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "OUTPUT" );
   AddComponent( textLabel5 );
   textLabel5.SetWantsMouseNotifications( false );
   textLabel5.SetPosition( 233, 326 );
   textLabel5.SetSize( 40, 15 );
   textLabel5.SetEditable( false, false );
   textLabel5.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel5.SetJustificationFlags( VoltageLabel.Justification.Bottom );
   textLabel5.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel5.SetBkColor( new Color( 88, 85, 85, 0 ) );
   textLabel5.SetBorderColor( new Color( 69, 134, 140, 0 ) );
   textLabel5.SetBorderSize( 1 );
   textLabel5.SetMultiLineEdit( false );
   textLabel5.SetIsNumberEditor( false );
   textLabel5.SetNumberEditorRange( 0, 100 );
   textLabel5.SetNumberEditorInterval( 1 );
   textLabel5.SetNumberEditorUsesMouseWheel( false );
   textLabel5.SetHasCustomTextHoverColor( false );
   textLabel5.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel5.SetFont( "Arial", 10, true, false );

   textLabel6 = new VoltageLabel( "textLabel6", "textLabel6", this, "INPUT" );
   AddComponent( textLabel6 );
   textLabel6.SetWantsMouseNotifications( false );
   textLabel6.SetPosition( 0, 198 );
   textLabel6.SetSize( 38, 18 );
   textLabel6.SetEditable( false, false );
   textLabel6.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel6.SetJustificationFlags( VoltageLabel.Justification.Bottom );
   textLabel6.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel6.SetBkColor( new Color( 88, 85, 85, 0 ) );
   textLabel6.SetBorderColor( new Color( 69, 134, 140, 0 ) );
   textLabel6.SetBorderSize( 1 );
   textLabel6.SetMultiLineEdit( false );
   textLabel6.SetIsNumberEditor( false );
   textLabel6.SetNumberEditorRange( 0, 100 );
   textLabel6.SetNumberEditorInterval( 1 );
   textLabel6.SetNumberEditorUsesMouseWheel( false );
   textLabel6.SetHasCustomTextHoverColor( false );
   textLabel6.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel6.SetFont( "Arial", 10, true, false );

   channel1Input = new VoltageAudioJack( "channel1Input", "Channel 1 Input", this, JackType.JackType_AudioInput );
   AddComponent( channel1Input );
   channel1Input.SetWantsMouseNotifications( false );
   channel1Input.SetPosition( 5, 88 );
   channel1Input.SetSize( 25, 25 );
   channel1Input.SetSkin( "Mini Jack 25px" );

   channel2Input = new VoltageAudioJack( "channel2Input", "Channel 2 Input", this, JackType.JackType_AudioInput );
   AddComponent( channel2Input );
   channel2Input.SetWantsMouseNotifications( false );
   channel2Input.SetPosition( 5, 118 );
   channel2Input.SetSize( 25, 25 );
   channel2Input.SetSkin( "Mini Jack 25px" );

   channel3Input = new VoltageAudioJack( "channel3Input", "Channel 3 Input", this, JackType.JackType_AudioInput );
   AddComponent( channel3Input );
   channel3Input.SetWantsMouseNotifications( false );
   channel3Input.SetPosition( 5, 148 );
   channel3Input.SetSize( 25, 25 );
   channel3Input.SetSkin( "Mini Jack 25px" );

   channel4Input = new VoltageAudioJack( "channel4Input", "Channel 4 Input", this, JackType.JackType_AudioInput );
   AddComponent( channel4Input );
   channel4Input.SetWantsMouseNotifications( false );
   channel4Input.SetPosition( 5, 178 );
   channel4Input.SetSize( 25, 25 );
   channel4Input.SetSkin( "Mini Jack 25px" );

   selectorGrid = new VoltageCanvas( "selectorGrid", "Channel Selector Grid", this, 240, 120 );
   AddComponent( selectorGrid );
   selectorGrid.SetWantsMouseNotifications( true );
   selectorGrid.SetPosition( 42, 85 );
   selectorGrid.SetSize( 240, 120 );

   clockInput = new VoltageAudioJack( "clockInput", "Clock Input", this, JackType.JackType_AudioInput );
   AddComponent( clockInput );
   clockInput.SetWantsMouseNotifications( false );
   clockInput.SetPosition( 19, 237 );
   clockInput.SetSize( 25, 25 );
   clockInput.SetSkin( "Mini Jack 25px" );

   resetInput = new VoltageAudioJack( "resetInput", "Reset Input", this, JackType.JackType_AudioInput );
   AddComponent( resetInput );
   resetInput.SetWantsMouseNotifications( false );
   resetInput.SetPosition( 57, 237 );
   resetInput.SetSize( 25, 25 );
   resetInput.SetSkin( "Mini Jack 25px" );

   outputJack = new VoltageAudioJack( "outputJack", "Output Jack", this, JackType.JackType_AudioOutput );
   AddComponent( outputJack );
   outputJack.SetWantsMouseNotifications( false );
   outputJack.SetPosition( 240, 301 );
   outputJack.SetSize( 25, 25 );
   outputJack.SetSkin( "Mini Jack 25px" );

   crossFadeKnob = new VoltageKnob( "crossFadeKnob", "Cross Fade Amount", this, 0, 1.0, 0.5 );
   AddComponent( crossFadeKnob );
   crossFadeKnob.SetWantsMouseNotifications( false );
   crossFadeKnob.SetPosition( 57, 301 );
   crossFadeKnob.SetSize( 27, 27 );
   crossFadeKnob.SetSkin( "Plastic Black" );
   crossFadeKnob.SetRange( 0, 1.0, 0.5, false, 0 );
   crossFadeKnob.SetKnobParams( 215, 145 );
   crossFadeKnob.DisplayValueInPercent( false );
   crossFadeKnob.SetKnobAdjustsRing( true );

   crossFadeCV = new VoltageAudioJack( "crossFadeCV", "Cross Fade CV", this, JackType.JackType_AudioInput );
   AddComponent( crossFadeCV );
   crossFadeCV.SetWantsMouseNotifications( false );
   crossFadeCV.SetPosition( 19, 301 );
   crossFadeCV.SetSize( 25, 25 );
   crossFadeCV.SetSkin( "Mini Jack 25px" );

   textLabel7 = new VoltageLabel( "textLabel7", "textLabel7", this, "CROSSFADE" );
   AddComponent( textLabel7 );
   textLabel7.SetWantsMouseNotifications( false );
   textLabel7.SetPosition( 7, 328 );
   textLabel7.SetSize( 88, 15 );
   textLabel7.SetEditable( false, false );
   textLabel7.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel7.SetJustificationFlags( VoltageLabel.Justification.Bottom );
   textLabel7.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel7.SetBkColor( new Color( 88, 85, 85, 0 ) );
   textLabel7.SetBorderColor( new Color( 69, 134, 140, 0 ) );
   textLabel7.SetBorderSize( 1 );
   textLabel7.SetMultiLineEdit( false );
   textLabel7.SetIsNumberEditor( false );
   textLabel7.SetNumberEditorRange( 0, 100 );
   textLabel7.SetNumberEditorInterval( 1 );
   textLabel7.SetNumberEditorUsesMouseWheel( false );
   textLabel7.SetHasCustomTextHoverColor( false );
   textLabel7.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel7.SetFont( "Arial", 10, true, false );

   textLabel8 = new VoltageLabel( "textLabel8", "textLabel8", this, "CLOCK" );
   AddComponent( textLabel8 );
   textLabel8.SetWantsMouseNotifications( false );
   textLabel8.SetPosition( 11, 266 );
   textLabel8.SetSize( 40, 15 );
   textLabel8.SetEditable( false, false );
   textLabel8.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel8.SetJustificationFlags( VoltageLabel.Justification.Bottom );
   textLabel8.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel8.SetBkColor( new Color( 88, 85, 85, 0 ) );
   textLabel8.SetBorderColor( new Color( 69, 134, 140, 0 ) );
   textLabel8.SetBorderSize( 1 );
   textLabel8.SetMultiLineEdit( false );
   textLabel8.SetIsNumberEditor( false );
   textLabel8.SetNumberEditorRange( 0, 100 );
   textLabel8.SetNumberEditorInterval( 1 );
   textLabel8.SetNumberEditorUsesMouseWheel( false );
   textLabel8.SetHasCustomTextHoverColor( false );
   textLabel8.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel8.SetFont( "Arial", 10, true, false );

   textLabel9 = new VoltageLabel( "textLabel9", "textLabel9", this, "RESET" );
   AddComponent( textLabel9 );
   textLabel9.SetWantsMouseNotifications( false );
   textLabel9.SetPosition( 52, 266 );
   textLabel9.SetSize( 40, 15 );
   textLabel9.SetEditable( false, false );
   textLabel9.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel9.SetJustificationFlags( VoltageLabel.Justification.Bottom );
   textLabel9.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel9.SetBkColor( new Color( 88, 85, 85, 0 ) );
   textLabel9.SetBorderColor( new Color( 69, 134, 140, 0 ) );
   textLabel9.SetBorderSize( 1 );
   textLabel9.SetMultiLineEdit( false );
   textLabel9.SetIsNumberEditor( false );
   textLabel9.SetNumberEditorRange( 0, 100 );
   textLabel9.SetNumberEditorInterval( 1 );
   textLabel9.SetNumberEditorUsesMouseWheel( false );
   textLabel9.SetHasCustomTextHoverColor( false );
   textLabel9.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel9.SetFont( "Arial", 10, true, false );

   textLabel10 = new VoltageLabel( "textLabel10", "textLabel10", this, "CROSS FADE GRID" );
   AddComponent( textLabel10 );
   textLabel10.SetWantsMouseNotifications( false );
   textLabel10.SetPosition( -12, 0 );
   textLabel10.SetSize( 300, 20 );
   textLabel10.SetEditable( false, false );
   textLabel10.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel10.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel10.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel10.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel10.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel10.SetBorderSize( 1 );
   textLabel10.SetMultiLineEdit( false );
   textLabel10.SetIsNumberEditor( false );
   textLabel10.SetNumberEditorRange( 0, 100 );
   textLabel10.SetNumberEditorInterval( 1 );
   textLabel10.SetNumberEditorUsesMouseWheel( false );
   textLabel10.SetHasCustomTextHoverColor( false );
   textLabel10.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel10.SetFont( "Arial", 12, true, false );

   textLabel11 = new VoltageLabel( "textLabel11", "textLabel11", this, "VULPUS LABS" );
   AddComponent( textLabel11 );
   textLabel11.SetWantsMouseNotifications( false );
   textLabel11.SetPosition( 0, 342 );
   textLabel11.SetSize( 300, 20 );
   textLabel11.SetEditable( false, false );
   textLabel11.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel11.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel11.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel11.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel11.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel11.SetBorderSize( 1 );
   textLabel11.SetMultiLineEdit( false );
   textLabel11.SetIsNumberEditor( false );
   textLabel11.SetNumberEditorRange( 0, 100 );
   textLabel11.SetNumberEditorInterval( 1 );
   textLabel11.SetNumberEditorUsesMouseWheel( false );
   textLabel11.SetHasCustomTextHoverColor( false );
   textLabel11.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel11.SetFont( "Arial", 10, true, false );

   stepCount = new VoltageDigitalCounter( "stepCount", "Step Count", this, 1 );
   AddComponent( stepCount );
   stepCount.SetWantsMouseNotifications( false );
   stepCount.SetPosition( 131, 233 );
   stepCount.SetSize( 42, 33 );
   stepCount.SetSkin( "Gray-Green" );
   stepCount.SetJustificationFlags( VoltageDigitalCounter.Justification.Centered );

   stepCountUp = new VoltageButton( "stepCountUp", "Step Count Up", this );
   AddComponent( stepCountUp );
   stepCountUp.SetWantsMouseNotifications( false );
   stepCountUp.SetPosition( 114, 236 );
   stepCountUp.SetSize( 15, 15 );
   stepCountUp.SetSkin( "Up Button" );
   stepCountUp.ShowOverlay( false );
   stepCountUp.SetOverlayText( "" );
   stepCountUp.SetAutoRepeat( false );

   stepCountDown = new VoltageButton( "stepCountDown", "Step Count Down", this );
   AddComponent( stepCountDown );
   stepCountDown.SetWantsMouseNotifications( false );
   stepCountDown.SetPosition( 114, 249 );
   stepCountDown.SetSize( 15, 15 );
   stepCountDown.SetSkin( "Down Button" );
   stepCountDown.ShowOverlay( false );
   stepCountDown.SetOverlayText( "" );
   stepCountDown.SetAutoRepeat( false );

   textLabel12 = new VoltageLabel( "textLabel12", "textLabel12", this, "STEP COUNT" );
   AddComponent( textLabel12 );
   textLabel12.SetWantsMouseNotifications( false );
   textLabel12.SetPosition( 100, 266 );
   textLabel12.SetSize( 88, 15 );
   textLabel12.SetEditable( false, false );
   textLabel12.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel12.SetJustificationFlags( VoltageLabel.Justification.Bottom );
   textLabel12.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel12.SetBkColor( new Color( 88, 85, 85, 0 ) );
   textLabel12.SetBorderColor( new Color( 69, 134, 140, 0 ) );
   textLabel12.SetBorderSize( 1 );
   textLabel12.SetMultiLineEdit( false );
   textLabel12.SetIsNumberEditor( false );
   textLabel12.SetNumberEditorRange( 0, 100 );
   textLabel12.SetNumberEditorInterval( 1 );
   textLabel12.SetNumberEditorUsesMouseWheel( false );
   textLabel12.SetHasCustomTextHoverColor( false );
   textLabel12.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel12.SetFont( "Arial", 10, true, false );

   volume1Knob = new VoltageKnob( "volume1Knob", "Volume 1", this, 0, 1.0, 0.5 );
   AddComponent( volume1Knob );
   volume1Knob.SetWantsMouseNotifications( false );
   volume1Knob.SetPosition( 46, 33 );
   volume1Knob.SetSize( 27, 27 );
   volume1Knob.SetSkin( "Plastic Black" );
   volume1Knob.SetRange( 0, 1.0, 0.5, false, 0 );
   volume1Knob.SetKnobParams( 215, 145 );
   volume1Knob.DisplayValueInPercent( false );
   volume1Knob.SetKnobAdjustsRing( true );

   volume1CV = new VoltageAudioJack( "volume1CV", "Input Volume 1 Control", this, JackType.JackType_AudioInput );
   AddComponent( volume1CV );
   volume1CV.SetWantsMouseNotifications( false );
   volume1CV.SetPosition( 18, 34 );
   volume1CV.SetSize( 25, 25 );
   volume1CV.SetSkin( "Mini Jack 25px" );

   textLabel13 = new VoltageLabel( "textLabel13", "textLabel13", this, "VOLUME 1" );
   AddComponent( textLabel13 );
   textLabel13.SetWantsMouseNotifications( false );
   textLabel13.SetPosition( 14, 58 );
   textLabel13.SetSize( 64, 15 );
   textLabel13.SetEditable( false, false );
   textLabel13.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel13.SetJustificationFlags( VoltageLabel.Justification.Bottom );
   textLabel13.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel13.SetBkColor( new Color( 88, 85, 85, 0 ) );
   textLabel13.SetBorderColor( new Color( 69, 134, 140, 0 ) );
   textLabel13.SetBorderSize( 1 );
   textLabel13.SetMultiLineEdit( false );
   textLabel13.SetIsNumberEditor( false );
   textLabel13.SetNumberEditorRange( 0, 100 );
   textLabel13.SetNumberEditorInterval( 1 );
   textLabel13.SetNumberEditorUsesMouseWheel( false );
   textLabel13.SetHasCustomTextHoverColor( false );
   textLabel13.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel13.SetFont( "Arial", 10, true, false );

   volume2Knob = new VoltageKnob( "volume2Knob", "Input Volume 2", this, 0, 1.0, 0.5 );
   AddComponent( volume2Knob );
   volume2Knob.SetWantsMouseNotifications( false );
   volume2Knob.SetPosition( 110, 33 );
   volume2Knob.SetSize( 27, 27 );
   volume2Knob.SetSkin( "Plastic Black" );
   volume2Knob.SetRange( 0, 1.0, 0.5, false, 0 );
   volume2Knob.SetKnobParams( 215, 145 );
   volume2Knob.DisplayValueInPercent( false );
   volume2Knob.SetKnobAdjustsRing( true );

   volume2CV = new VoltageAudioJack( "volume2CV", "Input Volume 2 Control", this, JackType.JackType_AudioInput );
   AddComponent( volume2CV );
   volume2CV.SetWantsMouseNotifications( false );
   volume2CV.SetPosition( 82, 34 );
   volume2CV.SetSize( 25, 25 );
   volume2CV.SetSkin( "Mini Jack 25px" );

   textLabel14 = new VoltageLabel( "textLabel14", "textLabel14", this, "VOLUME 2" );
   AddComponent( textLabel14 );
   textLabel14.SetWantsMouseNotifications( false );
   textLabel14.SetPosition( 78, 58 );
   textLabel14.SetSize( 64, 15 );
   textLabel14.SetEditable( false, false );
   textLabel14.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel14.SetJustificationFlags( VoltageLabel.Justification.Bottom );
   textLabel14.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel14.SetBkColor( new Color( 88, 85, 85, 0 ) );
   textLabel14.SetBorderColor( new Color( 69, 134, 140, 0 ) );
   textLabel14.SetBorderSize( 1 );
   textLabel14.SetMultiLineEdit( false );
   textLabel14.SetIsNumberEditor( false );
   textLabel14.SetNumberEditorRange( 0, 100 );
   textLabel14.SetNumberEditorInterval( 1 );
   textLabel14.SetNumberEditorUsesMouseWheel( false );
   textLabel14.SetHasCustomTextHoverColor( false );
   textLabel14.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel14.SetFont( "Arial", 10, true, false );

   volume3Knob = new VoltageKnob( "volume3Knob", "Input Volume 3", this, 0, 1.0, 0.5 );
   AddComponent( volume3Knob );
   volume3Knob.SetWantsMouseNotifications( false );
   volume3Knob.SetPosition( 174, 33 );
   volume3Knob.SetSize( 27, 27 );
   volume3Knob.SetSkin( "Plastic Black" );
   volume3Knob.SetRange( 0, 1.0, 0.5, false, 0 );
   volume3Knob.SetKnobParams( 215, 145 );
   volume3Knob.DisplayValueInPercent( false );
   volume3Knob.SetKnobAdjustsRing( true );

   volume3CV = new VoltageAudioJack( "volume3CV", "Input Volume 3 Control", this, JackType.JackType_AudioInput );
   AddComponent( volume3CV );
   volume3CV.SetWantsMouseNotifications( false );
   volume3CV.SetPosition( 146, 34 );
   volume3CV.SetSize( 25, 25 );
   volume3CV.SetSkin( "Mini Jack 25px" );

   textLabel15 = new VoltageLabel( "textLabel15", "textLabel15", this, "VOLUME 3" );
   AddComponent( textLabel15 );
   textLabel15.SetWantsMouseNotifications( false );
   textLabel15.SetPosition( 142, 58 );
   textLabel15.SetSize( 64, 15 );
   textLabel15.SetEditable( false, false );
   textLabel15.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel15.SetJustificationFlags( VoltageLabel.Justification.Bottom );
   textLabel15.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel15.SetBkColor( new Color( 88, 85, 85, 0 ) );
   textLabel15.SetBorderColor( new Color( 69, 134, 140, 0 ) );
   textLabel15.SetBorderSize( 1 );
   textLabel15.SetMultiLineEdit( false );
   textLabel15.SetIsNumberEditor( false );
   textLabel15.SetNumberEditorRange( 0, 100 );
   textLabel15.SetNumberEditorInterval( 1 );
   textLabel15.SetNumberEditorUsesMouseWheel( false );
   textLabel15.SetHasCustomTextHoverColor( false );
   textLabel15.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel15.SetFont( "Arial", 10, true, false );

   volume4Knob = new VoltageKnob( "volume4Knob", "Input Volume 4", this, 0, 1.0, 0.5 );
   AddComponent( volume4Knob );
   volume4Knob.SetWantsMouseNotifications( false );
   volume4Knob.SetPosition( 238, 33 );
   volume4Knob.SetSize( 27, 27 );
   volume4Knob.SetSkin( "Plastic Black" );
   volume4Knob.SetRange( 0, 1.0, 0.5, false, 0 );
   volume4Knob.SetKnobParams( 215, 145 );
   volume4Knob.DisplayValueInPercent( false );
   volume4Knob.SetKnobAdjustsRing( true );

   volume4CV = new VoltageAudioJack( "volume4CV", "Input Volume 4 Control", this, JackType.JackType_AudioInput );
   AddComponent( volume4CV );
   volume4CV.SetWantsMouseNotifications( false );
   volume4CV.SetPosition( 210, 34 );
   volume4CV.SetSize( 25, 25 );
   volume4CV.SetSkin( "Mini Jack 25px" );

   textLabel16 = new VoltageLabel( "textLabel16", "textLabel16", this, "VOLUME 4" );
   AddComponent( textLabel16 );
   textLabel16.SetWantsMouseNotifications( false );
   textLabel16.SetPosition( 206, 58 );
   textLabel16.SetSize( 64, 15 );
   textLabel16.SetEditable( false, false );
   textLabel16.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel16.SetJustificationFlags( VoltageLabel.Justification.Bottom );
   textLabel16.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel16.SetBkColor( new Color( 88, 85, 85, 0 ) );
   textLabel16.SetBorderColor( new Color( 69, 134, 140, 0 ) );
   textLabel16.SetBorderSize( 1 );
   textLabel16.SetMultiLineEdit( false );
   textLabel16.SetIsNumberEditor( false );
   textLabel16.SetNumberEditorRange( 0, 100 );
   textLabel16.SetNumberEditorInterval( 1 );
   textLabel16.SetNumberEditorUsesMouseWheel( false );
   textLabel16.SetHasCustomTextHoverColor( false );
   textLabel16.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel16.SetFont( "Arial", 10, true, false );
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
   channel1 = new Channel(channel1Input, volume1CV);
   channel2 = new Channel(channel2Input, volume2CV);
   channel3 = new Channel(channel3Input, volume3CV);
   channel4 = new Channel(channel4Input, volume4CV);
   crossFader = new CrossFader(
      new Channel[] { channel1, channel2, channel3, channel4 });
   stepCount.SetValue(gridState.getStepCount());


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
         if (component == volume1Knob) {
            channel1.setVolumeKnobValue(doubleValue);
         }
         if (component == volume2Knob) {
            channel2.setVolumeKnobValue(doubleValue);
         }
         if (component == volume3Knob) {
            channel3.setVolumeKnobValue(doubleValue);
         }
         if (component == volume4Knob) {
            channel4.setVolumeKnobValue(doubleValue);
         }
      }
      break;
   
      case Slider_Changed:   // doubleValue is the new slider value
      {
      }
      break;
   
      case Button_Changed:   // doubleValue is the new button/toggle button value
      {
         if (component == stepCountUp && doubleValue > 0) {
            stepCount.SetValue(gridState.incrementStepCount());
         }
         
         if (component == stepCountDown && doubleValue > 0) {
            stepCount.SetValue(gridState.decrementStepCount());
         }
      }
      break;
   
      case Switch_Changed:   // doubleValue is the new switch value
      {
      }
      break;
   
      case Jack_Connected:   // longValue is the new cable ID
      {
         if (component == channel1Input) {
            channel1.setInputIsConnected(true);
         }
         if (component == channel2Input) {
            channel2.setInputIsConnected(true);
         }
         if (component == channel3Input) {
            channel3.setInputIsConnected(true);
         }
         if (component == channel4Input) {
            channel4.setInputIsConnected(true);
         }
         if (component == volume1CV) {
            channel1.setVolumeCVIsConnected(true);
         }
         if (component == volume2CV) {
            channel2.setVolumeCVIsConnected(true);
         }
         if (component == volume3CV) {
            channel3.setVolumeCVIsConnected(true);
         }
         if (component == volume4CV) {
            channel4.setVolumeCVIsConnected(true);
         }
      }
      break;
   
      case Jack_Disconnected:   // All cables have been disconnected from this jack
      {
         if (component == channel1Input) {
            channel1.setInputIsConnected(false);
         }
         if (component == channel2Input) {
            channel2.setInputIsConnected(false);
         }
         if (component == channel3Input) {
            channel3.setInputIsConnected(false);
         }
         if (component == channel4Input) {
            channel4.setInputIsConnected(false);
         }
         if (component == volume1CV) {
            channel1.setVolumeCVIsConnected(false);
         }
         if (component == volume2CV) {
            channel2.setVolumeCVIsConnected(false);
         }
         if (component == volume3CV) {
            channel3.setVolumeCVIsConnected(false);
         }
         if (component == volume4CV) {
            channel4.setVolumeCVIsConnected(false);
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
         if (component == selectorGrid) {
            int width = selectorGrid.GetBitmapWidth();
            int height = selectorGrid.GetBitmapHeight();
            int cellWidth = width / 8;
            int cellHeight = height / 4;
            int col = x / cellWidth;
            int channel = y / cellHeight;
            gridState.setSelectedChannel(col, channel);
            selectorGrid.Invalidate();
         }
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
         paintCanvas();
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
         for (int c=0; c<8; c++) {
            int selected = ((int) (Values.FastRandom() * 4.0)) % 4;
            gridState.setSelectedChannel(c, selected);
         }
         stepCount.SetValue(gridState.randomiseStepCount());
         selectorGrid.Invalidate();
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
         for (int c=0; c<8; c++) {
            gridState.setSelectedChannel(c, 0);
         }
         stepCount.SetValue(gridState.resetStepCount());
         selectorGrid.Invalidate();
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
      if (clockInput.IsConnected()) {
         boolean isClock = clockInput.GetValue() > 0;
         if (isClock &! wasClock) {
            gridState.onClock();
            int currentInput = gridState.getCurrentSelectedChannel();
            crossFader.startCrossFade(currentInput, getCrossFadeSize());
         }
         wasClock = isClock;
         selectorGrid.Invalidate();
      }
      
      if (resetInput.IsConnected()) {
         boolean isReset = resetInput.GetValue() > 0;
         if (isReset &! wasReset) {
            gridState.onReset();
            int currentInput = gridState.getCurrentSelectedChannel();
            crossFader.startCrossFade(currentInput, getCrossFadeSize());
         }
         wasReset = isReset;
         selectorGrid.Invalidate();
      }
            
      outputJack.SetValue(crossFader.processSample());
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



   return gridState.getSaveState();
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
   gridState.setSaveState(stateInfo);
   stepCount.SetValue(gridState.getStepCount());
   selectorGrid.Invalidate();

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
private VoltageLabel textLabel16;
private VoltageAudioJack volume4CV;
private VoltageKnob volume4Knob;
private VoltageLabel textLabel15;
private VoltageAudioJack volume3CV;
private VoltageKnob volume3Knob;
private VoltageLabel textLabel14;
private VoltageAudioJack volume2CV;
private VoltageKnob volume2Knob;
private VoltageLabel textLabel13;
private VoltageAudioJack volume1CV;
private VoltageKnob volume1Knob;
private VoltageLabel textLabel12;
private VoltageButton stepCountDown;
private VoltageButton stepCountUp;
private VoltageDigitalCounter stepCount;
private VoltageLabel textLabel11;
private VoltageLabel textLabel10;
private VoltageLabel textLabel9;
private VoltageLabel textLabel8;
private VoltageLabel textLabel7;
private VoltageAudioJack crossFadeCV;
private VoltageKnob crossFadeKnob;
private VoltageAudioJack outputJack;
private VoltageAudioJack resetInput;
private VoltageAudioJack clockInput;
private VoltageCanvas selectorGrid;
private VoltageAudioJack channel4Input;
private VoltageAudioJack channel3Input;
private VoltageAudioJack channel2Input;
private VoltageAudioJack channel1Input;
private VoltageLabel textLabel6;
private VoltageLabel textLabel5;


//[user-code-and-variables]    Add your own variables and functions here



private boolean wasClock = false;
private boolean wasReset = false;
private CrossFader crossFader;
private GridState gridState = new GridState();
private Channel channel1;
private Channel channel2;
private Channel channel3;
private Channel channel4;

void paintCanvas() {
   Graphics2D g = selectorGrid.GetGraphics();
   g.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
   int width = selectorGrid.GetBitmapWidth();
   int height = selectorGrid.GetBitmapHeight();
   
   gridState.draw(g, width, height);
}

int getCrossFadeSize() {
   int result;
   if (crossFadeCV.IsConnected()) {
      double cvVal = crossFadeCV.GetValue();
      double clamped = Math.min(5.0, Math.max(cvVal, -5.0));
      double multiplier = (clamped + 5.0) / 10.0;
      result = 100 + (int) (crossFadeKnob.GetValue() * multiplier * 5900);
   } else {
      result = 100 + (int) (crossFadeKnob.GetValue() * 5900);
   }
   return result;
}

private static class GridState {
   private static Color UNLIT_GREY = new Color(24, 24, 24, 255);
   private static Color LIT_GREY = new Color(72, 72, 72, 255);
   private static Color LIT_GREY_NIMBUS = new Color(72, 72, 72, 128);
   private static Color UNLIT_GREEN = new Color(72, 72, 24, 255);
   private static Color LIT_GREEN = new Color(176, 176, 72, 255);
   private static Color LIT_GREEN_NIMBUS = new Color(176, 176, 72, 128);
   private static float[] KEYFRAMES = new float[] { 0.1f, 1f };
   private static Color[] SELECTED_GRAD = new Color[] { LIT_GREEN, UNLIT_GREEN };
   private static Color[] UNSELECTED_GRAD = new Color[] { LIT_GREY, UNLIT_GREY };
   private byte[] gridLights = new byte[8];
   private int currentCol = 0;
   private int stepCount = 8;
   
   
   GridState() {
   }
   
   public void draw(Graphics2D g, int width, int height) {
      g.setColor(Color.BLACK);
      g.fill3DRect(0, 0, width, height, true);
   
      int cellWidth = width / 8;
      int cellHeight = height / 4;
      float lightOffsetX = cellWidth * 0.4f;
      float lightOffsetY = cellWidth * 0.4f;
      float lightRadius = cellWidth * 0.75f;
        
      int topLeftX = 0;
      for (int x=0; x<8; x++) {
         int topLeftY = 0;
         int lit = gridLights[x];
         for (int y=0; y<4; y++) {
            
            if (x == currentCol) {
               Paint old = g.getPaint();
               if (y==lit) {
                  g.setPaint(new RadialGradientPaint(
                     topLeftX + lightOffsetX,
                     topLeftY + lightOffsetY,
                     lightRadius,
                     KEYFRAMES,
                     SELECTED_GRAD));
               } else {
                  g.setPaint(new RadialGradientPaint(
                     topLeftX + lightOffsetX,
                     topLeftY + lightOffsetY,
                     lightRadius,
                     KEYFRAMES,
                     UNSELECTED_GRAD));
               }
               g.fillRect(topLeftX + 2, topLeftY + 2, cellWidth - 4, cellHeight - 4);
               g.setPaint(old);
               g.setColor(y == lit ? LIT_GREEN_NIMBUS : LIT_GREY_NIMBUS);
               g.drawRect(topLeftX + 2, topLeftY + 2, cellWidth - 4, cellHeight - 4);
            } else {
               if (y==lit) {
                  g.setColor(UNLIT_GREEN);
               } else {
                  g.setColor(UNLIT_GREY);
               }
               g.fillRect(topLeftX + 2, topLeftY + 2, cellWidth - 4, cellHeight - 4);         
            }
            topLeftY += cellHeight;
         }
         topLeftX += cellWidth;
     }
   }
   
   public void onClock() {
      currentCol = (currentCol + 1) % stepCount;
   }
   
   public void onReset() {
      currentCol = 0;
   }
   
   public int getCurrentSelectedChannel() {
      return gridLights[currentCol];
   }
   
   public void setSelectedChannel(int col, int selectedChannel) {
      gridLights[col] = (byte) selectedChannel;
   }
   
   public byte[] getSaveState() {
      byte[] saveState = new byte[9];
      for (int i=0; i<8; i++) {
         saveState[i] = gridLights[i];
      }
      saveState[8] = (byte) stepCount;
      return saveState;
   }
   
   public void setSaveState(byte[] saveState) {
      for (int i=0; i<8; i++) {
         gridLights[i] = saveState[i];
      }
      stepCount = (int) saveState[8];
   }
   
   public int getStepCount() {
      return stepCount;
   }
   
   public int randomiseStepCount() {
      stepCount = 2 + (((int) (Values.FastRandom() * 7.0)) % 7);
      return stepCount;
   }
   
   public int resetStepCount() {
      stepCount = 8;
      return stepCount;
   }
   
   public int incrementStepCount() {
      stepCount = Math.min(stepCount + 1, 8);
      return stepCount;
   }
   
   public int decrementStepCount() {
      stepCount = Math.max(stepCount - 1, 2);
      return stepCount;
   }
}

private static class Channel {

   private final VoltageAudioJack input;
   private final VoltageAudioJack volumeCv;
   private boolean inputIsConnected;
   private boolean cvIsConnected;
   private double drive = 1.0;
   private double knobValue = 1.0;
   
   public Channel(VoltageAudioJack input, VoltageAudioJack volumeCv) {
      this.input = input;
      this.volumeCv = volumeCv;
   }
   
   public void setInputIsConnected(boolean inputIsConnected) {
      this.inputIsConnected = inputIsConnected;
   }
   
   public void setVolumeKnobValue(double value) {
      this.knobValue = value * 2.0;
   }
   
   public void setVolumeCVIsConnected(boolean cvIsConnected) {
      this.cvIsConnected = cvIsConnected;
   }
   
   public double getValue() {
      if (!inputIsConnected) {
         return 0.0;
      }
      double targetDrive = cvIsConnected
         ? knobValue * (volumeCv.GetValue() + 5.0) * 0.1
         : knobValue;
      drive = (drive * 0.99) + (targetDrive * 0.01);
      return input.GetValue() * drive;
   }
}

private static class CrossFader {

   private Channel[] channels;
   private Channel oldChannel;
   private Channel currentChannel;
   private int crossFadeCount = 0;
   private double crossFadePos = 0.0;
   private double crossFadePosDelta = 0.0;
   
   public CrossFader(Channel[] channels) {
      this.channels = channels;
      this.oldChannel = channels[0];
      this.currentChannel = channels[0];
   }
   
   public void startCrossFade(int targetChannel, int length) {
      if (crossFadeCount > 0) return;
      oldChannel = currentChannel;
      currentChannel = channels[targetChannel];
      if (oldChannel == currentChannel) return;
      crossFadeCount = length;
      crossFadePos = 0.0;
      crossFadePosDelta = 1.0 / (double) length;
   }
   
   public double processSample() {
      if (crossFadeCount == 0) {
         return currentChannel.getValue();
      }
      double oldSample = oldChannel.getValue();
      double currentSample = currentChannel.getValue();
      
      // Calculate sigmoid for smooth crossfade
      double squared = crossFadePos   * crossFadePos;
      double cubed   = squared * crossFadePos;
      double curveAmount = squared + squared + squared - (cubed + cubed);
      
      double interpolated = (currentSample * curveAmount) + (oldSample * (1.0 - curveAmount));
      crossFadeCount--;
      crossFadePos += crossFadePosDelta;
      return interpolated;
   }
      
}
//[/user-code-and-variables]
}

 