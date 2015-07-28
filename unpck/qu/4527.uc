class 4527 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect1
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		bSizeScale=True
		EffectClass=Class'LineageEffect.wh_heal_ta'
		bOnMultiTarget=True
	End Object
	Desc="Quset Boss Inc HP to Summoned" //Quset Boss Inc HP to Summoned
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect1',SpecificStage=0)
}