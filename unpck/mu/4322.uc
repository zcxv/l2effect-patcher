class 4322 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect10
		AttachOn=AM_LA
		bUseCharacterRotation=True
		bSpawnOnTarget=True
		bSizeScale=True
		EffectClass=Class'LineageEffect.sp_wind_walk_ta'
		bOnMultiTarget=True
	End Object
	Desc="초보용 윈드 워크" //Beginner Wind Walk
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect10',SpecificStage=0)
}