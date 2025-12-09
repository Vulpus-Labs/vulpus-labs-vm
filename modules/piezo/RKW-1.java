package com.vulpuslabs.rkw1;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
import com.vulpuslabs.modules.piezo.*;


//[/user-imports]


public class RKW1 extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

@SuppressWarnings("this-escape") 
public RKW1( long moduleID, VoltageObjects voltageObjects )
{
   super( moduleID, voltageObjects, "RKW-1", ModuleType.ModuleType_Oscillators, 2.0 );

   InitializeControls();


   canBeBypassed = false;
   SetSkin( "fa1216ce1fd04ede970a0e17ec4f5250" );
}

void InitializeControls()
{

   audioOut = new VoltageAudioJack( "audioOut", "Audio Ou", this, JackType.JackType_AudioOutput );
   AddComponent( audioOut );
   audioOut.SetWantsMouseNotifications( false );
   audioOut.SetPosition( 114, 317 );
   audioOut.SetSize( 25, 25 );
   audioOut.SetSkin( "Jack Round White Ring" );

   voctIn1 = new VoltageAudioJack( "voctIn1", "V/Oct In 1", this, JackType.JackType_AudioInput );
   AddComponent( voctIn1 );
   voctIn1.SetWantsMouseNotifications( false );
   voctIn1.SetPosition( 35, 60 );
   voctIn1.SetSize( 25, 25 );
   voctIn1.SetSkin( "Jack Round Red Ring" );

   voctIn2 = new VoltageAudioJack( "voctIn2", "V/Oct In 2", this, JackType.JackType_AudioInput );
   AddComponent( voctIn2 );
   voctIn2.SetWantsMouseNotifications( false );
   voctIn2.SetPosition( 35, 95 );
   voctIn2.SetSize( 25, 25 );
   voctIn2.SetSkin( "Jack Round Yellow Ring" );

   voctIn3 = new VoltageAudioJack( "voctIn3", "V/Oct In 3", this, JackType.JackType_AudioInput );
   AddComponent( voctIn3 );
   voctIn3.SetWantsMouseNotifications( false );
   voctIn3.SetPosition( 35, 130 );
   voctIn3.SetSize( 25, 25 );
   voctIn3.SetSkin( "Jack Round Green Ring" );

   voctIn4 = new VoltageAudioJack( "voctIn4", "V/Oct In 4", this, JackType.JackType_AudioInput );
   AddComponent( voctIn4 );
   voctIn4.SetWantsMouseNotifications( false );
   voctIn4.SetPosition( 35, 165 );
   voctIn4.SetSize( 25, 25 );
   voctIn4.SetSkin( "Jack Round Sky Ring" );

   gateIn1 = new VoltageAudioJack( "gateIn1", "Gate In 1", this, JackType.JackType_AudioInput );
   AddComponent( gateIn1 );
   gateIn1.SetWantsMouseNotifications( false );
   gateIn1.SetPosition( 75, 60 );
   gateIn1.SetSize( 25, 25 );
   gateIn1.SetSkin( "Jack Round Red Ring" );

   gateIn2 = new VoltageAudioJack( "gateIn2", "Gate In 2", this, JackType.JackType_AudioInput );
   AddComponent( gateIn2 );
   gateIn2.SetWantsMouseNotifications( false );
   gateIn2.SetPosition( 75, 95 );
   gateIn2.SetSize( 25, 25 );
   gateIn2.SetSkin( "Jack Round Yellow Ring" );

   gateIn3 = new VoltageAudioJack( "gateIn3", "Gate In 3", this, JackType.JackType_AudioInput );
   AddComponent( gateIn3 );
   gateIn3.SetWantsMouseNotifications( false );
   gateIn3.SetPosition( 75, 130 );
   gateIn3.SetSize( 25, 25 );
   gateIn3.SetSkin( "Jack Round Green Ring" );

   gateIn4 = new VoltageAudioJack( "gateIn4", "Gate In 4", this, JackType.JackType_AudioInput );
   AddComponent( gateIn4 );
   gateIn4.SetWantsMouseNotifications( false );
   gateIn4.SetPosition( 75, 165 );
   gateIn4.SetSize( 25, 25 );
   gateIn4.SetSkin( "Jack Round Sky Ring" );

   pulseWidthIn1 = new VoltageAudioJack( "pulseWidthIn1", "Pulse With In 1", this, JackType.JackType_AudioInput );
   AddComponent( pulseWidthIn1 );
   pulseWidthIn1.SetWantsMouseNotifications( false );
   pulseWidthIn1.SetPosition( 115, 60 );
   pulseWidthIn1.SetSize( 25, 25 );
   pulseWidthIn1.SetSkin( "Jack Round Red Ring" );

   pulseWidthIn2 = new VoltageAudioJack( "pulseWidthIn2", "Pulse With In 2", this, JackType.JackType_AudioInput );
   AddComponent( pulseWidthIn2 );
   pulseWidthIn2.SetWantsMouseNotifications( false );
   pulseWidthIn2.SetPosition( 115, 95 );
   pulseWidthIn2.SetSize( 25, 25 );
   pulseWidthIn2.SetSkin( "Jack Round Yellow Ring" );

   pulseWidthIn3 = new VoltageAudioJack( "pulseWidthIn3", "Pulse With In 3", this, JackType.JackType_AudioInput );
   AddComponent( pulseWidthIn3 );
   pulseWidthIn3.SetWantsMouseNotifications( false );
   pulseWidthIn3.SetPosition( 115, 130 );
   pulseWidthIn3.SetSize( 25, 25 );
   pulseWidthIn3.SetSkin( "Jack Round Green Ring" );

   audioBudgetPercentKnob = new VoltageKnob( "audioBudgetPercentKnob", "Audio Budget Percent", this, 50, 100, 100 );
   AddComponent( audioBudgetPercentKnob );
   audioBudgetPercentKnob.SetWantsMouseNotifications( false );
   audioBudgetPercentKnob.SetPosition( 6, 195 );
   audioBudgetPercentKnob.SetSize( 27, 27 );
   audioBudgetPercentKnob.SetSkin( "Plastic White" );
   audioBudgetPercentKnob.SetRange( 50, 100, 100, false, 0 );
   audioBudgetPercentKnob.SetKnobParams( 215, 145 );
   audioBudgetPercentKnob.DisplayValueInPercent( false );
   audioBudgetPercentKnob.SetKnobAdjustsRing( true );

   videoModeSwitch = new VoltageSwitch( "videoModeSwitch", "PAL / NTSC", this, 0 );
   AddComponent( videoModeSwitch );
   videoModeSwitch.SetWantsMouseNotifications( false );
   videoModeSwitch.SetPosition( 55, 20 );
   videoModeSwitch.SetSize( 37, 15 );
   videoModeSwitch.SetSkin( "Rocker Switch Plastic Black Hor" );

   tickLengthKnob = new VoltageKnob( "tickLengthKnob", "Tick Length", this, 50, 200, 50 );
   AddComponent( tickLengthKnob );
   tickLengthKnob.SetWantsMouseNotifications( false );
   tickLengthKnob.SetPosition( 51, 195 );
   tickLengthKnob.SetSize( 27, 27 );
   tickLengthKnob.SetSkin( "Plastic Black" );
   tickLengthKnob.SetRange( 50, 200, 50, false, 151 );
   tickLengthKnob.SetKnobParams( 215, 145 );
   tickLengthKnob.SetUnits( "cycles" );
   tickLengthKnob.DisplayValueInPercent( false );
   tickLengthKnob.SetKnobAdjustsRing( true );

   resetPhaseSwitch = new VoltageSwitch( "resetPhaseSwitch", "Reset Phase On Sync", this, 0 );
   AddComponent( resetPhaseSwitch );
   resetPhaseSwitch.SetWantsMouseNotifications( false );
   resetPhaseSwitch.SetPosition( 94, 202 );
   resetPhaseSwitch.SetSize( 37, 15 );
   resetPhaseSwitch.SetSkin( "Rocker Switch Plastic Black Hor" );

   textLabel1 = new VoltageLabel( "textLabel1", "textLabel1", this, "RKW-1" );
   AddComponent( textLabel1 );
   textLabel1.SetWantsMouseNotifications( false );
   textLabel1.SetPosition( -1, 0 );
   textLabel1.SetSize( 145, 15 );
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
   textLabel1.SetFont( "Arial Black", 12, false, false );

   textLabel2 = new VoltageLabel( "textLabel2", "textLabel2", this, "VULPUS LABS" );
   AddComponent( textLabel2 );
   textLabel2.SetWantsMouseNotifications( false );
   textLabel2.SetPosition( -1, 345 );
   textLabel2.SetSize( 145, 15 );
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
   textLabel2.SetFont( "Arial Black", 12, false, false );

   textLabel3 = new VoltageLabel( "textLabel3", "textLabel3", this, "CHAN" );
   AddComponent( textLabel3 );
   textLabel3.SetWantsMouseNotifications( false );
   textLabel3.SetPosition( 0, 40 );
   textLabel3.SetSize( 30, 14 );
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
   textLabel3.SetFont( "Arial Black", 10, false, false );

   textLabel4 = new VoltageLabel( "textLabel4", "textLabel4", this, "FREQ" );
   AddComponent( textLabel4 );
   textLabel4.SetWantsMouseNotifications( false );
   textLabel4.SetPosition( 35, 40 );
   textLabel4.SetSize( 25, 15 );
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
   textLabel4.SetFont( "Arial Black", 10, false, false );

   textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "GATE" );
   AddComponent( textLabel5 );
   textLabel5.SetWantsMouseNotifications( false );
   textLabel5.SetPosition( 75, 40 );
   textLabel5.SetSize( 25, 15 );
   textLabel5.SetEditable( false, false );
   textLabel5.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel5.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel5.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel5.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel5.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel5.SetBorderSize( 1 );
   textLabel5.SetMultiLineEdit( false );
   textLabel5.SetIsNumberEditor( false );
   textLabel5.SetNumberEditorRange( 0, 100 );
   textLabel5.SetNumberEditorInterval( 1 );
   textLabel5.SetNumberEditorUsesMouseWheel( false );
   textLabel5.SetHasCustomTextHoverColor( false );
   textLabel5.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel5.SetFont( "Arial Black", 10, false, false );

   textLabel6 = new VoltageLabel( "textLabel6", "textLabel6", this, "P/W" );
   AddComponent( textLabel6 );
   textLabel6.SetWantsMouseNotifications( false );
   textLabel6.SetPosition( 115, 40 );
   textLabel6.SetSize( 25, 15 );
   textLabel6.SetEditable( false, false );
   textLabel6.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel6.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel6.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel6.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel6.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel6.SetBorderSize( 1 );
   textLabel6.SetMultiLineEdit( false );
   textLabel6.SetIsNumberEditor( false );
   textLabel6.SetNumberEditorRange( 0, 100 );
   textLabel6.SetNumberEditorInterval( 1 );
   textLabel6.SetNumberEditorUsesMouseWheel( false );
   textLabel6.SetHasCustomTextHoverColor( false );
   textLabel6.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel6.SetFont( "Arial Black", 10, false, false );

   textLabel7 = new VoltageLabel( "textLabel7", "textLabel7", this, "1" );
   AddComponent( textLabel7 );
   textLabel7.SetWantsMouseNotifications( false );
   textLabel7.SetPosition( 0, 65 );
   textLabel7.SetSize( 30, 15 );
   textLabel7.SetEditable( false, false );
   textLabel7.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel7.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel7.SetColor( new Color( 255, 0, 3, 255 ) );
   textLabel7.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel7.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel7.SetBorderSize( 1 );
   textLabel7.SetMultiLineEdit( false );
   textLabel7.SetIsNumberEditor( false );
   textLabel7.SetNumberEditorRange( 0, 100 );
   textLabel7.SetNumberEditorInterval( 1 );
   textLabel7.SetNumberEditorUsesMouseWheel( false );
   textLabel7.SetHasCustomTextHoverColor( false );
   textLabel7.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel7.SetFont( "Arial Black", 12, false, false );

   textLabel8 = new VoltageLabel( "textLabel8", "textLabel8", this, "2" );
   AddComponent( textLabel8 );
   textLabel8.SetWantsMouseNotifications( false );
   textLabel8.SetPosition( 0, 100 );
   textLabel8.SetSize( 30, 15 );
   textLabel8.SetEditable( false, false );
   textLabel8.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel8.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel8.SetColor( new Color( 253, 255, 0, 255 ) );
   textLabel8.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel8.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel8.SetBorderSize( 1 );
   textLabel8.SetMultiLineEdit( false );
   textLabel8.SetIsNumberEditor( false );
   textLabel8.SetNumberEditorRange( 0, 100 );
   textLabel8.SetNumberEditorInterval( 1 );
   textLabel8.SetNumberEditorUsesMouseWheel( false );
   textLabel8.SetHasCustomTextHoverColor( false );
   textLabel8.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel8.SetFont( "Arial Black", 12, false, false );

   textLabel9 = new VoltageLabel( "textLabel9", "textLabel9", this, "3" );
   AddComponent( textLabel9 );
   textLabel9.SetWantsMouseNotifications( false );
   textLabel9.SetPosition( 0, 135 );
   textLabel9.SetSize( 30, 15 );
   textLabel9.SetEditable( false, false );
   textLabel9.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel9.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel9.SetColor( new Color( 0, 255, 3, 255 ) );
   textLabel9.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel9.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel9.SetBorderSize( 1 );
   textLabel9.SetMultiLineEdit( false );
   textLabel9.SetIsNumberEditor( false );
   textLabel9.SetNumberEditorRange( 0, 100 );
   textLabel9.SetNumberEditorInterval( 1 );
   textLabel9.SetNumberEditorUsesMouseWheel( false );
   textLabel9.SetHasCustomTextHoverColor( false );
   textLabel9.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel9.SetFont( "Arial Black", 12, false, false );

   textLabel10 = new VoltageLabel( "textLabel10", "textLabel10", this, "NOISE" );
   AddComponent( textLabel10 );
   textLabel10.SetWantsMouseNotifications( false );
   textLabel10.SetPosition( 2, 170 );
   textLabel10.SetSize( 30, 15 );
   textLabel10.SetEditable( false, false );
   textLabel10.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel10.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel10.SetColor( new Color( 1, 255, 254, 255 ) );
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
   textLabel10.SetFont( "Arial Black", 12, false, false );

   textLabel11 = new VoltageLabel( "textLabel11", "textLabel11", this, "PAL" );
   AddComponent( textLabel11 );
   textLabel11.SetWantsMouseNotifications( false );
   textLabel11.SetPosition( 29, 21 );
   textLabel11.SetSize( 25, 14 );
   textLabel11.SetEditable( false, false );
   textLabel11.SetJustificationFlags( VoltageLabel.Justification.Right );
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
   textLabel11.SetFont( "Arial Black", 10, false, false );

   textLabel12 = new VoltageLabel( "textLabel12", "textLabel12", this, "NTSC" );
   AddComponent( textLabel12 );
   textLabel12.SetWantsMouseNotifications( false );
   textLabel12.SetPosition( 91, 21 );
   textLabel12.SetSize( 30, 14 );
   textLabel12.SetEditable( false, false );
   textLabel12.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel12.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel12.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel12.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel12.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel12.SetBorderSize( 1 );
   textLabel12.SetMultiLineEdit( false );
   textLabel12.SetIsNumberEditor( false );
   textLabel12.SetNumberEditorRange( 0, 100 );
   textLabel12.SetNumberEditorInterval( 1 );
   textLabel12.SetNumberEditorUsesMouseWheel( false );
   textLabel12.SetHasCustomTextHoverColor( false );
   textLabel12.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel12.SetFont( "Arial Black", 10, false, false );

   textLabel13 = new VoltageLabel( "textLabel13", "textLabel13", this, "AUDIO BUDGET" );
   AddComponent( textLabel13 );
   textLabel13.SetWantsMouseNotifications( false );
   textLabel13.SetPosition( 4, 224 );
   textLabel13.SetSize( 30, 27 );
   textLabel13.SetEditable( false, false );
   textLabel13.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel13.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel13.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel13.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel13.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel13.SetBorderSize( 1 );
   textLabel13.SetMultiLineEdit( false );
   textLabel13.SetIsNumberEditor( false );
   textLabel13.SetNumberEditorRange( 0, 100 );
   textLabel13.SetNumberEditorInterval( 1 );
   textLabel13.SetNumberEditorUsesMouseWheel( false );
   textLabel13.SetHasCustomTextHoverColor( false );
   textLabel13.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel13.SetFont( "Arial Black", 10, false, false );

   textLabel14 = new VoltageLabel( "textLabel14", "textLabel14", this, "TICK LENGTH" );
   AddComponent( textLabel14 );
   textLabel14.SetWantsMouseNotifications( false );
   textLabel14.SetPosition( 50, 224 );
   textLabel14.SetSize( 30, 27 );
   textLabel14.SetEditable( false, false );
   textLabel14.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel14.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel14.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel14.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel14.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel14.SetBorderSize( 1 );
   textLabel14.SetMultiLineEdit( false );
   textLabel14.SetIsNumberEditor( false );
   textLabel14.SetNumberEditorRange( 0, 100 );
   textLabel14.SetNumberEditorInterval( 1 );
   textLabel14.SetNumberEditorUsesMouseWheel( false );
   textLabel14.SetHasCustomTextHoverColor( false );
   textLabel14.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel14.SetFont( "Arial Black", 10, false, false );

   textLabel15 = new VoltageLabel( "textLabel15", "textLabel15", this, "PHASE RESET" );
   AddComponent( textLabel15 );
   textLabel15.SetWantsMouseNotifications( false );
   textLabel15.SetPosition( 95, 224 );
   textLabel15.SetSize( 30, 27 );
   textLabel15.SetEditable( false, false );
   textLabel15.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel15.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel15.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel15.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel15.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel15.SetBorderSize( 1 );
   textLabel15.SetMultiLineEdit( false );
   textLabel15.SetIsNumberEditor( false );
   textLabel15.SetNumberEditorRange( 0, 100 );
   textLabel15.SetNumberEditorInterval( 1 );
   textLabel15.SetNumberEditorUsesMouseWheel( false );
   textLabel15.SetHasCustomTextHoverColor( false );
   textLabel15.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel15.SetFont( "Arial Black", 10, false, false );

   mixModeSwitch = new VoltageSwitch( "mixModeSwitch", "Mix Mode", this, 0 );
   AddComponent( mixModeSwitch );
   mixModeSwitch.SetWantsMouseNotifications( false );
   mixModeSwitch.SetPosition( 45, 260 );
   mixModeSwitch.SetSize( 52, 15 );
   mixModeSwitch.SetSkin( "4-State Slide Horiz" );

   textLabel16 = new VoltageLabel( "textLabel16", "textLabel16", this, "OR" );
   AddComponent( textLabel16 );
   textLabel16.SetWantsMouseNotifications( false );
   textLabel16.SetPosition( 4, 296 );
   textLabel16.SetSize( 30, 15 );
   textLabel16.SetEditable( false, false );
   textLabel16.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel16.SetJustificationFlags( VoltageLabel.Justification.Top );
   textLabel16.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel16.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel16.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel16.SetBorderSize( 1 );
   textLabel16.SetMultiLineEdit( false );
   textLabel16.SetIsNumberEditor( false );
   textLabel16.SetNumberEditorRange( 0, 100 );
   textLabel16.SetNumberEditorInterval( 1 );
   textLabel16.SetNumberEditorUsesMouseWheel( false );
   textLabel16.SetHasCustomTextHoverColor( false );
   textLabel16.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel16.SetFont( "Arial Black", 10, false, false );

   textLabel17 = new VoltageLabel( "textLabel17", "textLabel17", this, "XOR" );
   AddComponent( textLabel17 );
   textLabel17.SetWantsMouseNotifications( false );
   textLabel17.SetPosition( 34, 296 );
   textLabel17.SetSize( 30, 15 );
   textLabel17.SetEditable( false, false );
   textLabel17.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel17.SetJustificationFlags( VoltageLabel.Justification.Top );
   textLabel17.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel17.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel17.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel17.SetBorderSize( 1 );
   textLabel17.SetMultiLineEdit( false );
   textLabel17.SetIsNumberEditor( false );
   textLabel17.SetNumberEditorRange( 0, 100 );
   textLabel17.SetNumberEditorInterval( 1 );
   textLabel17.SetNumberEditorUsesMouseWheel( false );
   textLabel17.SetHasCustomTextHoverColor( false );
   textLabel17.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel17.SetFont( "Arial Black", 10, false, false );

   textLabel18 = new VoltageLabel( "textLabel18", "textLabel18", this, "INTER LEAVE" );
   AddComponent( textLabel18 );
   textLabel18.SetWantsMouseNotifications( false );
   textLabel18.SetPosition( 64, 296 );
   textLabel18.SetSize( 30, 25 );
   textLabel18.SetEditable( false, false );
   textLabel18.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel18.SetJustificationFlags( VoltageLabel.Justification.Top );
   textLabel18.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel18.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel18.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel18.SetBorderSize( 1 );
   textLabel18.SetMultiLineEdit( true );
   textLabel18.SetIsNumberEditor( false );
   textLabel18.SetNumberEditorRange( 0, 100 );
   textLabel18.SetNumberEditorInterval( 1 );
   textLabel18.SetNumberEditorUsesMouseWheel( false );
   textLabel18.SetHasCustomTextHoverColor( false );
   textLabel18.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel18.SetFont( "Arial Black", 10, false, false );

   textLabel19 = new VoltageLabel( "textLabel19", "textLabel19", this, "MIX MODE" );
   AddComponent( textLabel19 );
   textLabel19.SetWantsMouseNotifications( false );
   textLabel19.SetPosition( 8, 253 );
   textLabel19.SetSize( 30, 30 );
   textLabel19.SetEditable( false, false );
   textLabel19.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel19.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel19.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel19.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel19.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel19.SetBorderSize( 1 );
   textLabel19.SetMultiLineEdit( true );
   textLabel19.SetIsNumberEditor( false );
   textLabel19.SetNumberEditorRange( 0, 100 );
   textLabel19.SetNumberEditorInterval( 1 );
   textLabel19.SetNumberEditorUsesMouseWheel( false );
   textLabel19.SetHasCustomTextHoverColor( false );
   textLabel19.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel19.SetFont( "Arial Black", 10, false, false );

   textLabel20 = new VoltageLabel( "textLabel20", "textLabel20", this, "QUAD" );
   AddComponent( textLabel20 );
   textLabel20.SetWantsMouseNotifications( false );
   textLabel20.SetPosition( 104, 296 );
   textLabel20.SetSize( 30, 13 );
   textLabel20.SetEditable( false, false );
   textLabel20.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel20.SetJustificationFlags( VoltageLabel.Justification.Top );
   textLabel20.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel20.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel20.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel20.SetBorderSize( 1 );
   textLabel20.SetMultiLineEdit( true );
   textLabel20.SetIsNumberEditor( false );
   textLabel20.SetNumberEditorRange( 0, 100 );
   textLabel20.SetNumberEditorInterval( 1 );
   textLabel20.SetNumberEditorUsesMouseWheel( false );
   textLabel20.SetHasCustomTextHoverColor( false );
   textLabel20.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel20.SetFont( "Arial Black", 10, false, false );

   textLabel21 = new VoltageLabel( "textLabel21", "textLabel21", this, "OUTPUT" );
   AddComponent( textLabel21 );
   textLabel21.SetWantsMouseNotifications( false );
   textLabel21.SetPosition( 70, 316 );
   textLabel21.SetSize( 40, 27 );
   textLabel21.SetEditable( false, false );
   textLabel21.SetJustificationFlags( VoltageLabel.Justification.Right );
   textLabel21.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel21.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel21.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel21.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel21.SetBorderSize( 1 );
   textLabel21.SetMultiLineEdit( false );
   textLabel21.SetIsNumberEditor( false );
   textLabel21.SetNumberEditorRange( 0, 100 );
   textLabel21.SetNumberEditorInterval( 1 );
   textLabel21.SetNumberEditorUsesMouseWheel( false );
   textLabel21.SetHasCustomTextHoverColor( false );
   textLabel21.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel21.SetFont( "Arial Black", 10, false, false );
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
         if (component == audioBudgetPercentKnob) {
            engine.setAudioBudgetPercent(doubleValue);
         }
         if (component == tickLengthKnob) {
            engine.setTickLengthInCycles((int) doubleValue);
         }
      }
      break;
   
      case Slider_Changed:   // doubleValue is the new slider value
      {
      }
      break;
   
      case Button_Changed:   // doubleValue is the new button/toggle button value
      {
      }
      break;
   
      case Switch_Changed:   // doubleValue is the new switch value
      {
         if (component == videoModeSwitch) {
            if (doubleValue == 0) {
               engine.setSyncToPal();
            } else {
               engine.setSyncToNtsc();
            }
         }
         
         if (component == resetPhaseSwitch) {
            engine.setResetPhase(doubleValue > 0.0);
         }
         
         if (component == mixModeSwitch) {
            engine.setMixMode(switch((int) component.GetValue()) {
               case 0 -> MixMode.OR;
               case 1 -> MixMode.XOR;
               case 2 -> MixMode.INTERLEAVE;
               default -> MixMode.QUAD;
            });
         }
      }
      break;
   
      case Jack_Connected:   // longValue is the new cable ID
      {
      }
      break;
   
      case Jack_Disconnected:   // All cables have been disconnected from this jack
      {
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
   engine.setChannel(
      0,
      voctIn1.GetValue(),
      gateIn1.GetValue() > 0.0,
      0x7FFF + (int) (0x5000 * pulseWidthIn1.GetValue() * 0.2));

   engine.setChannel(
      1,
      voctIn2.GetValue(),
      gateIn2.GetValue() > 0.0,
      0x7FFF + (int) (0x5000 * pulseWidthIn2.GetValue() * 0.2));

   engine.setChannel(
      2,
      voctIn3.GetValue(),
      gateIn3.GetValue() > 0.0,
      0x7FFF + (int) (0x5000 * pulseWidthIn3.GetValue() * 0.2));

   engine.setChannel(
      3,
      voctIn4.GetValue(),
      gateIn4.GetValue() > 0.0,
      0x7FFF);
      
   audioOut.SetValue(engine.processSample());
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
   if (component == videoModeSwitch) {
      return component.GetValue() == 0.0 ? "PAL (50Hz refresh)" : "NTSC (60Hz refresh)";
   }
   
   if (component == mixModeSwitch) {
      return switch((int) component.GetValue()) {
         case 0 -> "OR all channels";
         case 1 -> "XOR all channels";
         case 2 -> "Interleave channels";
         default -> "Quad mode (four separate generators)";
      };
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
private VoltageLabel textLabel21;
private VoltageLabel textLabel20;
private VoltageLabel textLabel19;
private VoltageLabel textLabel18;
private VoltageLabel textLabel17;
private VoltageLabel textLabel16;
private VoltageSwitch mixModeSwitch;
private VoltageLabel textLabel15;
private VoltageLabel textLabel14;
private VoltageLabel textLabel13;
private VoltageLabel textLabel12;
private VoltageLabel textLabel11;
private VoltageLabel textLabel10;
private VoltageLabel textLabel9;
private VoltageLabel textLabel8;
private VoltageLabel textLabel7;
private VoltageLabel textLabel6;
private VoltageLabel textLabel5;
private VoltageLabel textLabel4;
private VoltageLabel textLabel3;
private VoltageLabel textLabel2;
private VoltageLabel textLabel1;
private VoltageSwitch resetPhaseSwitch;
private VoltageKnob tickLengthKnob;
private VoltageSwitch videoModeSwitch;
private VoltageKnob audioBudgetPercentKnob;
private VoltageAudioJack pulseWidthIn3;
private VoltageAudioJack pulseWidthIn2;
private VoltageAudioJack pulseWidthIn1;
private VoltageAudioJack gateIn4;
private VoltageAudioJack gateIn3;
private VoltageAudioJack gateIn2;
private VoltageAudioJack gateIn1;
private VoltageAudioJack voctIn4;
private VoltageAudioJack voctIn3;
private VoltageAudioJack voctIn2;
private VoltageAudioJack voctIn1;
private VoltageAudioJack audioOut;


//[user-code-and-variables]    Add your own variables and functions here
private final SpectrumEngine engine = new SpectrumEngine();




//[/user-code-and-variables]
}

 